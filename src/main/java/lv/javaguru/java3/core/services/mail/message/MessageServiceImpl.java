package lv.javaguru.java3.core.services.mail.message;

import lv.javaguru.java3.core.database.mail.MessageDAO;
import lv.javaguru.java3.core.database.mail.RecipientDAO;
import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.domain.mail.*;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.mail.folder.FolderService;
import lv.javaguru.java3.core.services.mail.folder.FolderValidator;
import lv.javaguru.java3.core.services.mail.exception.MessageRecipientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.domain.mail.FolderBuilder.createFolder;
import static lv.javaguru.java3.core.domain.mail.FolderCategoryBuilder.createFolderCategory;
import static lv.javaguru.java3.core.domain.mail.MessageBuilder.createMessage;

/**
 * Created by Andrew on 17.11.2015.
 */
@Component
public class MessageServiceImpl implements MessageService {

    @Autowired private MessageDAO messageDAO;
    @Autowired private MessageValidator validator;
    @Autowired private RecipientDAO recipientDAO;
    @Autowired private FolderService folderService;
    @Autowired private UserDAO userDAO;

    @Override
    public Message send(User sender,
                        String title,
                        String body,
                        List<User> usersRecipients,
                        boolean isImportant) throws Exception{

        validator.validate(sender, title, body, usersRecipients, isImportant);

        Message message = createMessage()
                .withSender(sender)
                .withTitle(title)
                .withBody(body)
                .withRecipients(toRecipientList(usersRecipients, sender))
                .isImportant(isImportant)
                .isActive(true)
                .build();

        messageDAO.create(message);

        return message;

    }

    @Override
    public Message get(Long messageId) throws Exception {
        return messageDAO.getById(messageId);
    }

    @Override
    public List<Recipient> list(long folderId) throws Exception {
        List<Recipient> recipientList = recipientDAO.getByFolderId(folderId);
        return recipientList;
    }

    @Override
    public void moveToFolder(long messageId, long userId, long newFolderId) throws Exception {
        Folder folder = folderService.get(newFolderId);

        try {
            Recipient recipient = getRecipient(userId, messageId);
            recipient.setFolder(folder);
            recipientDAO.update(recipient);
        } catch (MessageRecipientNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long messageId, long userId) throws Exception {
        try {
            Recipient recipient = getRecipient(userId, messageId);
            if (folderService.isDeleted(recipient.getFolder())) {
                recipient.setIsActive(false);
            } else {
                recipient.setFolder(folderService.getDeleted(userDAO.getById(userId)));
            }
            recipientDAO.update(recipient);
        } catch (MessageRecipientNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public int getMessagesCount(Folder folder) throws Exception {
        return recipientDAO.getMessagesCount(folder.getId());
    }

    @Override
    public int getUnreadMessageCount(long folderId) throws Exception {
        return recipientDAO.getUnreadMessageCount(folderId);
    }


    private List<Recipient> toRecipientList(List<User> usersRecipients, User sender) {
        List<Recipient> recipientList = new ArrayList<>();
        for (User user : usersRecipients)
            recipientList.add(createInboxRecipient(user));
        recipientList.add(createSentRecipient(sender));
        return recipientList;
    }

    private Recipient createInboxRecipient(User user) {
        return RecipientBuilder.createRecipient()
                .withUserId(user.getId())
                .withFolder(folderService.getInbox(user))
                .isUnread(true)
                .build();
    }

    private Recipient createSentRecipient(User user) {
        return RecipientBuilder.createRecipient()
                .withUserId(user.getId())
                .withFolder(folderService.getSent(user))
                .isUnread(false)
                .build();
    }

    private Recipient getRecipient(long userId, long messageId)
            throws MessageRecipientNotFoundException {

        for (Recipient r : messageDAO.getById(messageId).getRecipients())
            if (r.getUserId() == userId)
                return r;

        throw new MessageRecipientNotFoundException();
    }
}
