package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.user.User;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import static lv.javaguru.java3.core.domain.StateBuilder.createState;

import java.util.Date;

@Component
class UserDAOImpl extends CRUDOperationDAOImpl<User, Long> implements UserDAO {

    @Override
    public void create(User entity) {
        entity.setLastModified(new Date());
        entity.setState(createState().created().build());
        getCurrentSession().save(entity);
    }

    @Override
    public void update(User entity) {
        entity.setLastModified(new Date());
        entity.setState(createState().modified().build());
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(User entity) {
        Transaction tx = getCurrentSession().beginTransaction();
        User a = (User)getCurrentSession().get(daoType, entity.getId());
        getCurrentSession().delete(a);
        tx.commit();
    }
}
