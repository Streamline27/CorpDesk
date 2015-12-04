package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.domain.user.User;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
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
        user.setPassword(encrypt(user.getPassword()));
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

    @Override
    public int validate(String login, String password) {
        User user = userDAO.getByLogin(login);
        if(user==null)
            return 1;
        if (!getEncryptor().checkPassword(password, user.getPassword()))
            return 2;

        return 0;
    }

    @Override
    public int changePassword(String login, String oldPassword, String newPassword) {
        User user = userDAO.getByLogin(login);
        if(user==null)
            return 1;

        if (!getEncryptor().checkPassword(oldPassword, user.getPassword()))
            return 2;

        user.setPassword(encrypt(newPassword));
        userDAO.update(user);
        return 0;
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
