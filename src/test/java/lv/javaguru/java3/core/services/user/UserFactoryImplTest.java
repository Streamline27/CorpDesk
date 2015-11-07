package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.domain.user.Role;
import lv.javaguru.java3.core.domain.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserFactoryImplTest {

    @Mock private UserValidator userValidator;
    @Mock private UserDAO userDAO;

    @InjectMocks
    private UserFactory userFactory = new UserFactoryImpl();

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final Role ROLE = new Role();
    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";
    private static final String EMAIL = "email@email.lv";


    @Test
    public void createShouldInvokeValidator() throws Exception {
        userFactory.create(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL);
        verify(userValidator).validate(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfValidationFail() throws Exception {
        doThrow(new IllegalArgumentException())
                .when(userValidator).validate(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL);
        userFactory.create(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL);
    }

    @Test
    public void createShouldPersistUserAfterValidation() throws Exception {
        User user = userFactory.create(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL);
        InOrder inOrder = inOrder(userValidator, userDAO);
        inOrder.verify(userValidator).validate(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL);
        inOrder.verify(userDAO).create(user);
    }

    @Test
    public void createShouldReturnNewUser() throws Exception {
        User user = userFactory.create(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL);
        assertThat(user.getLogin(), is(LOGIN));
        assertThat(user.getPassword(), is(PASSWORD));
    }

}
