package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.user.Group;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;

@Component
class GroupDAOImpl extends CRUDOperationDAOImpl<Group, Long> implements GroupDAO {

    @Override
    public void create(Group entity) {
        entity.setLastModified(new Date());
        getCurrentSession().save(entity);
    }

    @Override
    public void update(Group entity) {
        entity.setLastModified(new Date());
        getCurrentSession().update(entity);
    }
}
