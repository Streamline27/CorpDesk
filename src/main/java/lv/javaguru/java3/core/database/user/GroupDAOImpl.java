package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.user.Group;
import lv.javaguru.java3.core.domain.user.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

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

    @Override
    public Group getByName(String name) {
        List<Group> list =  getCurrentSession().createCriteria(Group.class)
                .add(Restrictions.eq("name", name))
                .list();

        return list==null || list.isEmpty() ? null : list.get(0);
    }
}
