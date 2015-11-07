package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.domain.user.Group;
import lv.javaguru.java3.core.domain.user.Role;
import lv.javaguru.java3.core.domain.user.User;

import java.util.List;


public interface UserService {

    List<User> getAll();

    User create(String login, String password, Role role, String firstName, String lastName,
                String email) throws Exception;

    User update(long userId, String password, Role role, String firstName, String lastName,
                String email, List<Group> groups);

    User get(long userId);

    User delete(long userId);
}
