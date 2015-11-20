package lv.javaguru.java3.core.services.mail.message;

import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.Message;
import lv.javaguru.java3.core.domain.user.User;

import java.util.List;

/**
 * Created by Andrew on 17.11.2015.
 */
public interface MessageService {

    Message send(User sender,
                 String title,
                 String body,
                 List<User> recipients,
                 boolean isImportant);

    Message get(Long messageId);

    void moveToFolder(Message message, User user, Folder newFolder);

    void delete(User user, Message message);

    int getUnreadMessageCount(User user);

}
