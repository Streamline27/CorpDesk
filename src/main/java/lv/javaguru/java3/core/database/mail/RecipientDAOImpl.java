package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.mail.Recipient;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Andrew on 13.11.2015.
 */

@Component
public class RecipientDAOImpl extends CRUDOperationDAOImpl<Recipient, Long> implements RecipientDAO {

    @Override
    public List<Recipient> getByFolderId(long folderId) {
        return getCurrentSession().createCriteria(Recipient.class)
                .add(Restrictions.and(
                        Restrictions.eq("folder.id", folderId),
                        Restrictions.eq("isActive", true)
                ))
                .list();
    }

    @Override
    public int getMessagesCount(long folderId) {
        return ( (BigInteger) getCurrentSession().createSQLQuery("SELECT COUNT(*) FROM recipients " +
                "WHERE folder_id = '" + folderId + "' AND is_active = '1'").list().get(0)).intValue();
    }

    @Override
    public int getUnreadMessageCount(long folderId) {
        return ( (BigInteger) getCurrentSession()
                .createSQLQuery("SELECT COUNT(*) FROM recipients WHERE folder_id = '" + folderId +
                        "' AND is_active = '1' AND is_unread = '1'").list().get(0)).intValue();
    }

}
