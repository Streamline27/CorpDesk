package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.domain.user.Role;
import lv.javaguru.java3.core.domain.user.User;

public interface UserFactory {

    User create(String login, String password, Role userRole, String firstName, String lastName, String email) throws Exception;

}
