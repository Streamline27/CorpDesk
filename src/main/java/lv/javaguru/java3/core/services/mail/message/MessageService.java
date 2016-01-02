package lv.javaguru.java3.core.services.mail.message;

import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.Message;
import lv.javaguru.java3.core.domain.mail.Recipient;
import lv.javaguru.java3.core.domain.user.User;

import java.util.List;

/**
 * Created by Andrew on 17.11.2015.
 */
public interface MessageService {

    Message send(long senderId,
                 String title,
                 String body,
                 List<User> recipients,
                 boolean isImportant) throws Exception;

    Message get(Long messageId) throws Exception;

    List<Recipient> list(long folderId) throws Exception;

    void moveToFolder(long messageId, long userId, long destinationFolderId) throws Exception;

    void delete(long userId, long messageId) throws Exception;

    int getMessagesCount(Folder folder) throws Exception;

    int getUnreadMessageCount(long folderId) throws Exception;

}
