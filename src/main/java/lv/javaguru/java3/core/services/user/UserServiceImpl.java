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

    private final UserDAO userDAO;
    private final UserFactory userFactory;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, UserFactory userFactory) {
        this.userDAO = userDAO;
        this.userFactory = userFactory;
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User create(String login, String password, Role role, String firstName, String lastName, String email) throws Exception {
        return userFactory.create(login, password, role, firstName, lastName, email);
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
