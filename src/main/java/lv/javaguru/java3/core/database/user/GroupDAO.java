package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.CRUDOperationDAO;
import lv.javaguru.java3.core.domain.user.Group;

public interface GroupDAO extends CRUDOperationDAO<Group, Long> {

    Group getByName(String name);
}
