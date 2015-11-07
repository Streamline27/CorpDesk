package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.user.UserLog;
import org.hibernate.JDBCException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

import static lv.javaguru.java3.core.domain.user.UserLogBuilder.createUserLog;


@Component
class UserLogDAOImpl extends CRUDOperationDAOImpl<UserLog, Long> implements UserLogDAO {

    @Override
    public List<UserLog> getAll(long userLogId) throws JDBCException {
        UserLog userLog = createUserLog().withUserId(userLogId).build();
        return getCurrentSession().createCriteria(UserLogDAO.class)
                .add(Restrictions.eq("userId", userLog))
                .list();

    }
}
