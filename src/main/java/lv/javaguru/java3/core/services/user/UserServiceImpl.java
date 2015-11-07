package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.domain.user.Group;
import lv.javaguru.java3.core.domain.user.Role;
import lv.javaguru.java3.core.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class UserServiceImpl implements UserService {

    @Autowired private UserDAO userDAO;
    @Autowired private UserValidator userValidator;


    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User create(String login, String password, Role role, String firstName, String lastName, String email) {
        return null;
    }

    @Override
    public User update(long userId, String password, Role role, String firstName, String lastName, String email, List<Group> groups) {
        return null;
    }

    @Override
    public User get(long userId) {
        return null;
    }

    @Override
    public User delete(long userId) {
        return null;
    }
}
