package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.FolderCategory;
import lv.javaguru.java3.core.domain.user.User;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Andrew on 15.11.2015.
 */

@Component
public class FolderDAOImpl extends CRUDOperationDAOImpl<Folder, Long> implements FolderDAO {

    @Override
    public List<Folder> listByUserId(long userId) {
        return getCurrentSession().createCriteria(Folder.class)
                .add(Restrictions.eq("userId", userId))
                .addOrder(Order.asc("name"))
                .list();
    }

    @Override
    public Folder getByCategory(long userId, FolderCategory folderCategory) {
        return (Folder) getCurrentSession().createCriteria(Folder.class)
                .add(Restrictions.and(
                        Restrictions.eq("userId", userId),
                        Restrictions.eq("category", folderCategory)
                )).list().get(0);
    }

}
