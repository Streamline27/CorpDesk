package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.CRUDOperationDAO;
import lv.javaguru.java3.core.domain.mail.Message;
import lv.javaguru.java3.core.domain.mail.Recipient;
import lv.javaguru.java3.core.domain.user.User;

import java.util.List;

/**
 * Created by Andrew on 13.11.2015.
 */
public interface RecipientDAO extends CRUDOperationDAO<Recipient, Long>{

    List<Recipient> getByUserId(long userId);

    int getUnreadMessageCount(long userId);
}
