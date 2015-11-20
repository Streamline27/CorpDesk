package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.mail.Recipient;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Andrew on 13.11.2015.
 */

@Component
public class RecipientDAOImpl extends CRUDOperationDAOImpl<Recipient, Long> implements RecipientDAO {

    @Override
    public List<Recipient> getByUserId(long userId) {
        return getCurrentSession().createCriteria(Recipient.class)
                .add(Restrictions.and(
                        Restrictions.eq("userId", userId),
                        Restrictions.eq("isActive", true)
                )).list();
    }

    @Override
    public int getUnreadMessageCount(long userId) {
        return getCurrentSession().createCriteria(Recipient.class)
                .add(Restrictions.and(
                        Restrictions.eq("userId", userId),
                        Restrictions.eq("isUnread", true),
                        Restrictions.eq("isActive", true)))
                .list().size();
    }

}
