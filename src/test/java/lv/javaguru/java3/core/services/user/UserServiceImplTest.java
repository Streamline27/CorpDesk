package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.config.AppCoreConfig;
import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.domain.user.Role;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.CommandExecutorImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppCoreConfig.class})
public class UserServiceImplTest {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final Role ROLE = new Role();
    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";
    private static final String EMAIL = "email@email.lv";

    @Mock
    private UserDAO userDAO;
    @Mock
    private UserValidator userValidator;
    @InjectMocks
    private UserServiceImpl userService;

    @InjectMocks
    private CommandExecutorImpl commandExecutor;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUserCommandHandler() throws Exception {
        User user = createUser()
                .withLogin(LOGIN)
                .withPassword(PASSWORD)
                .withUserRole(ROLE)
                .withFirstName(FIRST_NAME)
                .withLastName(LAST_NAME)
                .withEmail(EMAIL)
                .build();
        userService.create(user);
        verify(userDAO).create(user);
        verify(userValidator).validate(user, false);
    }
}
