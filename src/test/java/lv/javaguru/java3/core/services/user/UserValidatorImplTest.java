package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.domain.user.Role;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class UserValidatorImplTest {

    private final UserValidator validator = new UserValidatorImpl();

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final Role ROLE = new Role();
    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";
    private static final String EMAIL = "email@email.lv";

    @Before
    public void setUp(){
        ROLE.setId(2);
    }

    @Test
    public void validateShouldFailIfLoginIsNull() {
        validateShouldFail(null, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL, "User login must not be null");
    }

    @Test
    public void validateShouldFailIfLoginIsEmpty() {
        validateShouldFail("", PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL, "User login must not be empty");
    }

    @Test
    public void validateShouldFailIfPasswordIsNull() {
        validateShouldFail(LOGIN, null, ROLE, FIRST_NAME, LAST_NAME, EMAIL, "User password must not be null");
    }

    @Test
    public void validateShouldFailIfPasswordIsEmpty() {
        validateShouldFail(LOGIN, "", ROLE, FIRST_NAME, LAST_NAME, EMAIL, "User password must not be empty");
    }

    @Test
    public void validateShouldFailIfRoleNull() {
        validateShouldFail(LOGIN, PASSWORD, null, FIRST_NAME, LAST_NAME, EMAIL, null);
    }

    @Test
    public void validateShouldFailIfRoleId0() {
        ROLE.setId(0);
        validateShouldFail(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, EMAIL, null);
    }

    @Test
    public void validateShouldFailIfFirstNameIsNull() {
        validateShouldFail(LOGIN, PASSWORD, ROLE, null, LAST_NAME, EMAIL, "User first name must not be null");
    }

    @Test
    public void validateShouldFailIfFirstNameIsEmpty() {
        validateShouldFail(LOGIN, PASSWORD, ROLE, "", LAST_NAME, EMAIL, "User first name must not be empty");
    }

    @Test
    public void validateShouldFailIfLastNameIsNull() {
        validateShouldFail(LOGIN, PASSWORD, ROLE, FIRST_NAME, null, EMAIL, "User last name must not be null");
    }

    @Test
    public void validateShouldFailIfLastNameIsEmpty() {
        validateShouldFail(LOGIN, PASSWORD, ROLE, FIRST_NAME, "", EMAIL, "User last name must not be empty");
    }

    @Test
    public void validateShouldFailIfEmailIsInvalid() {
        validateShouldFail(LOGIN, PASSWORD, ROLE, FIRST_NAME, LAST_NAME, "ss", "Invalid Email Address");
    }

    private void validateShouldFail(String login, String password, Role role,
                                    String firstName, String lastName, String email,
                                    String errorMessage) {
        try {
            validator.validate(login, password, role, firstName, lastName, email);
            fail();
        } catch (Exception e) {
            if (errorMessage!=null)
                assertThat(e.getMessage(), is(errorMessage));
        }
    }

}
