package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.domain.user.Role;

public interface UserValidator {

    void validate(String login, String password, Role role, String firstName, String lastName,
                  String email) throws Exception;
}
