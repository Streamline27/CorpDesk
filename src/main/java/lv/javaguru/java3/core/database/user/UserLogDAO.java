package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.CRUDOperationDAO;
import lv.javaguru.java3.core.domain.user.UserLog;
import org.hibernate.JDBCException;

import java.util.List;

public interface UserLogDAO extends CRUDOperationDAO<UserLog, Long> {

    List<UserLog> getAll(long userLogId) throws JDBCException;
}
