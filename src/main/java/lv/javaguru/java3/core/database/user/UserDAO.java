package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.CRUDOperationDAO;
import lv.javaguru.java3.core.domain.user.User;

public interface UserDAO extends CRUDOperationDAO<User, Long> {

    User getByLogin(String login);

}
