package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.user.User;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Andrew on 15.11.2015.
 */

@Component
public class FolderDAOImpl extends CRUDOperationDAOImpl<Folder, Long> implements FolderDAO {

    public List<Folder> getByUser(long userId) {
        /*
        return getCurrentSession().createSQLQuery(
                "SELECT *.message_folders " +
                        "FROM message_folders, message_folder_catgories " +
                        "WHERE message_folders.user_id = '" + user.getId() + "' " +
                        "AND message_folders.category_id = message_folder_category.id " +
                        "ORDER BY message.folder_category.id ASC, message_folders.name ASC").list();
        */
        return getCurrentSession().createCriteria(Folder.class)
                .add(Restrictions.eq("userId", userId))
                .addOrder(Order.asc("name"))
                .list();
    }
}
