package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.user.exception.InvalidPasswordException;
import lv.javaguru.java3.core.services.user.exception.UserNotFoundException;

import java.util.List;


public interface UserService {

    List<User> getAll();

    void create(User user) throws Exception;

    void update(User user) throws Exception;

    User get(long userId);

    void delete(long userId);

    int validate(String login, String password);

    void changePassword(String login, String oldPassword, String newPassword) throws Exception;
}
