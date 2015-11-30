package lv.javaguru.java3.core.services.mail.message;

import lv.javaguru.java3.core.database.mail.MessageDAO;
import lv.javaguru.java3.core.database.mail.RecipientDAO;
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
    @Autowired private FolderValidator folderValidator;

    @Override
    public Message send(User sender,
                        String title,
                        String body,
                        List<User> usersRecipients,
                        boolean isImportant) {

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
    public Message getById(Long messageId) {
        return messageDAO.getById(messageId);
    }

    @Override
    public List<Recipient> list(long folderId) {
        return recipientDAO.getByFolderId(folderId);
    }

    @Override
    public void moveToFolder(Message message, User user, Folder newFolder) {
        folderValidator.validate(newFolder);

        try {
            Recipient recipient = getRecipient(user, message);
            recipient.setFolder(newFolder);
            recipientDAO.update(recipient);
        } catch (MessageRecipientNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user, Message message) {
        try {
            Recipient recipient = getRecipient(user, message);
            if (folderService.isDeleted(recipient.getFolder())) {
                recipient.setIsActive(false);
            } else {
                recipient.setFolder(folderService.getDeleted(user));
            }
            recipientDAO.update(recipient);
        } catch (MessageRecipientNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getUnreadMessageCount(User user) {
        return recipientDAO.getUnreadMessageCount(user.getId());
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
                .withFolder(createFolder().withCategory(createFolderCategory().inbox().build()).build())
                .isUnread(true)
                .build();
    }

    private Recipient createSentRecipient(User user) {
        return RecipientBuilder.createRecipient()
                .withUserId(user.getId())
                .withFolder(createFolder().withCategory(createFolderCategory().sent().build()).build())
                .isUnread(false)
                .build();
    }

    private Recipient getRecipient(User user, Message message)
            throws MessageRecipientNotFoundException {

        for (Recipient r : message.getRecipients())
            if (r.getUserId() == user.getId())
                return r;

        throw new MessageRecipientNotFoundException();
    }
}
