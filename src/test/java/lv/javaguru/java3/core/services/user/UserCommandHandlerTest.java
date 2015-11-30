package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.config.AppCoreConfig;
import lv.javaguru.java3.core.domain.user.Role;
import lv.javaguru.java3.core.domain.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppCoreConfig.class})
public class UserCommandHandlerTest  {

    @Mock
    private UserServiceImpl userService;
    @Mock
    private User user;
    @InjectMocks
    private CreateUserCommandHandler commandExecutor;

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final Role ROLE = new Role();
    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";
    private static final String EMAIL = "email@email.lv";

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUserCommandHandler() throws Exception {
   /*     when(userService.create(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL))
                .thenReturn(user);

        CreateGroupCommand createUserCommand =
                new CreateGroupCommand(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL);
        commandExecutor.execute(createUserCommand);
        verify(userService).create(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL);*/
    }
}
