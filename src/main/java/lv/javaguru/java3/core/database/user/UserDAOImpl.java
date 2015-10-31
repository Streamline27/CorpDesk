package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.user.User;
import org.springframework.stereotype.Component;
import static lv.javaguru.java3.core.domain.StateBuilder.createState;

import java.util.Date;

@Component
class UserDAOImpl extends CRUDOperationDAOImpl<User, Long> implements UserDAO {

    @Override
    public void create(User entity) {
        entity.setLastModified(new Date());
        entity.setState(createState().created().build());
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(User entity) {
        entity.setLastModified(new Date());
        entity.setState(createState().modified().build());
        getCurrentSession().saveOrUpdate(entity);
    }
}
