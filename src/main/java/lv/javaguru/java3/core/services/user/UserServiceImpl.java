package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private UserValidator userValidator;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, UserValidator userValidator) {
        this.userDAO = userDAO;
        this.userValidator = userValidator;
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void create(User user) throws Exception {
        userValidator.validate(user);
        userDAO.create(user);
    }

    @Override
    public void update(User user) throws Exception {
        userValidator.validate(user);
        userDAO.update(user);
    }

    @Override
    public User get(long userId) {
        return userDAO.getById(userId);
    }

    @Override
    public void delete(long userId) {
        User user = userDAO.getRequired(userId);
        userDAO.delete(user);
    }
}
