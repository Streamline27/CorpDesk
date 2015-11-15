package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.domain.user.Role;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.user.exception.InvalidEmailException;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

@Component
class UserValidatorImpl implements UserValidator {

    @Override
    public void validate(User user) throws Exception {
        validateLogin(user.getLogin());
        validatePassword(user.getPassword());
        validateRole(user.getUserRole());
        validateFirstName(user.getFirstName());
        validateLastName(user.getLastName());
        validateEmail(user.getEmail());
    }

    private void validateLogin(String login) {
        notNull(login, "login");
    }

    private void validatePassword(String password) {
        notNull(password, "password");
    }

    private void validateRole(Role role) throws Exception {
        if (role == null || role.getId() < 1)
            throw new Exception();
    }

    private void validateFirstName(String firstName) {
        notNull(firstName, "first name");
    }

    private void validateLastName(String lastName) {
        notNull(lastName, "last name");
    }

    public void validateEmail(String email) throws InvalidEmailException {
        if (email != null && email.length()>0) {
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(email);
            if (email.length() != 0 && !m.matches())
                throw new InvalidEmailException();
        }
    }

    private void notNull(String field, String name){
        checkNotNull(field, String.format("User %s must not be null", name));
        checkArgument(!isBlank(field), String.format("User %s must not be empty", name));
    }

}
