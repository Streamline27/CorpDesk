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

    List getByFolderId(long folderId);
    int getMessagesCount(long folderId);
    int getUnreadMessageCount(long folderId);
    Recipient getByMessageIdAndUserId(long messageId, long userId);

}
