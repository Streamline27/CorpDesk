package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.domain.user.User;

public interface UserValidator {

    void validate(User user, Boolean mustExist) throws Exception;

    void validateChangePassword(String login, String oldPassword, String newPassword) throws Exception;
}
