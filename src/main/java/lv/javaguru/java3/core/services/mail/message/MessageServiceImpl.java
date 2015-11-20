package lv.javaguru.java3.core.services.mail.message;

import lv.javaguru.java3.core.database.mail.MessageDAO;
import lv.javaguru.java3.core.database.mail.RecipientDAO;
import lv.javaguru.java3.core.domain.mail.*;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.mail.message.exception.MessageRecipientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.domain.mail.FolderBuilder.createFolder;
import static lv.javaguru.java3.core.domain.mail.FolderCategoryBuilder.createFolderCategory;
import static lv.javaguru.java3.core.domain.mail.MessageBuilder.createMessage;

/**
 * Created by Andrew on 17.11.2015.
 */
public class MessageServiceImpl implements MessageService {

    @Autowired private MessageDAO messageDAO;
    @Autowired private MessageValidator validator;
    @Autowired private RecipientDAO recipientDAO;

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
    public Message get(Long messageId) {
        return messageDAO.getById(messageId);
    }

    @Override
    public void moveToFolder(Message message, User user, Folder newFolder) {
        // TODO Validate if newFolder exists and belongs to user

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
            if (recipient.getFolder().getCategory().equals(createFolderCategory().deleted().build())) {
                recipient.setIsActive(false);
            } else {
                recipient.setFolder(getDeletedFolder(user));
            }
            recipientDAO.update(recipient);
        } catch (MessageRecipientNotFoundException e) {
            e.printStackTrace();
        }


    }

    private Folder getDeletedFolder(User user) {
        // maybe create static getters? (If not exists - create, otherwise - return existing folder)
        return null;
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
