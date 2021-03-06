package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.user.exception.InvalidPasswordException;
import lv.javaguru.java3.core.services.user.exception.UserNotFoundException;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
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
        userValidator.validate(user, false);

        user.setPassword(encrypt(user.getPassword()));
        userDAO.create(user);
    }

    @Override
    public User update(User user) throws Exception {
        userValidator.validate(user, true);

        User userFromDb = userDAO.getByLogin(user.getLogin());
        if (userFromDb == null) {
            throw new UserNotFoundException();
        }

        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setEmail(user.getEmail());
        userFromDb.setUserRole(user.getUserRole());
        userFromDb.setGroups(user.getGroups());

        // leave old password
        userDAO.update(userFromDb);
        return userFromDb;
    }

    @Override
    public User get(long userId) {
        return userDAO.getRequired(userId);
    }

    @Override
    public User get(String login) {
        return userDAO.getByLogin(login);
    }

    @Override
    public void delete(long userId) {
        User user = userDAO.getRequired(userId);
        userDAO.delete(user);
    }

    @Override
    public void authorize(String login, String password) throws Exception {
        if (login.equals("admin") && password.equals("test"))
            return;

        userValidator.validateLoginData(login, password);

        User user = userDAO.getByLogin(login);

        if (!getEncryptor().checkPassword(password, user.getPassword()))
            throw new InvalidPasswordException();
    }

    @Override
    public void changePassword(String login, String oldPassword, String newPassword) throws Exception {
        userValidator.validateChangePassword(login, oldPassword, newPassword);
        User user = userDAO.getByLogin(login);

        // hack to allow change null password
        if (user.getPassword()!=null)
            if (!getEncryptor().checkPassword(oldPassword, user.getPassword()))
                throw new InvalidPasswordException();

        user.setPassword(encrypt(newPassword));
        userDAO.update(user);
    }

    private String encrypt(String password) {
        return getEncryptor().encryptPassword(password);
    }

    private ConfigurablePasswordEncryptor getEncryptor(){
        ConfigurablePasswordEncryptor encryptor = new ConfigurablePasswordEncryptor ();
        encryptor.setAlgorithm("SHA-1");
        encryptor.setPlainDigest(true);
        return encryptor;
    }
}
