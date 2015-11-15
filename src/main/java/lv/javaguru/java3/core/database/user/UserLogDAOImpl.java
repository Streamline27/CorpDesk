package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.user.UserLog;
import org.hibernate.JDBCException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

import static lv.javaguru.java3.core.domain.user.UserLogBuilder.createUserLog;


@Component
class UserLogDAOImpl extends CRUDOperationDAOImpl<UserLog, Long> implements UserLogDAO {

    @Override
    public List<UserLog> getAll(long userId) throws JDBCException {
         return getCurrentSession().createCriteria(UserLog.class)
                .add(Restrictions.eq("userId", userId))
                .list();

    }
}
