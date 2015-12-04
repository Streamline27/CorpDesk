package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.domain.user.User;

import java.util.List;


public interface UserService {

    List<User> getAll();

    void create(User user) throws Exception;

    void update(User user) throws Exception;

    User get(long userId);

    void delete(long userId);

    int validate(String login, String password);

    int changePassword(String login, String oldPassword, String newPassword);
}
