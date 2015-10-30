package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.user.Group;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
class GroupDAOImpl extends CRUDOperationDAOImpl<Group, Long> implements GroupDAO {

    @Override
    public void create(Group entity) {
        entity.setLastModified(new Date());
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(Group entity) {
        entity.setLastModified(new Date());
        getCurrentSession().saveOrUpdate(entity);
    }
}
