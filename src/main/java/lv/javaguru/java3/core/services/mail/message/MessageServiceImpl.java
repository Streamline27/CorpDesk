package lv.javaguru.java3.core.services.mail.message;

import lv.javaguru.java3.core.database.mail.MessageDAO;
import lv.javaguru.java3.core.database.mail.RecipientDAO;
import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.domain.mail.*;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.mail.exception.DestinationFolderNotFoundException;
import lv.javaguru.java3.core.services.mail.exception.MessageNotFoundException;
import lv.javaguru.java3.core.services.mail.folder.FolderService;
import lv.javaguru.java3.core.services.mail.exception.MessageRecipientNotFoundException;
import lv.javaguru.java3.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired private UserService userService;

    @Override
    public Message send(long senderId,
                        String title,
                        String body,
                        List<User> usersRecipients,
                        boolean isImportant) throws Exception{

        validator.validate(senderId, title, body, usersRecipients, isImportant);

        Message message = createMessage()
                .withSenderId(senderId)
                .withTitle(title)
                .withBody(body)
                .withRecipients(toRecipientList(usersRecipients, senderId))
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
    public void moveToFolder(long messageId, long userId, long destinationFolderId) throws Exception {

        Folder destinationFolder = folderService.get(destinationFolderId);
        if (destinationFolder == null) throw new DestinationFolderNotFoundException();

        try {
            Recipient recipient = recipientDAO.getByMessageIdAndUserId(messageId, userId);
            recipient.setFolder(destinationFolder);
            recipientDAO.update(recipient);
        } catch (IndexOutOfBoundsException e) {
            throw new MessageNotFoundException();
        } catch (Exception e) {
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
                recipient.setFolder(folderService.getDeleted(userService.get(userId)));
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


    private List<Recipient> toRecipientList(List<User> usersRecipients, long senderId) {
        List<Recipient> recipientList = new ArrayList<>();
        for (User user : usersRecipients)
            recipientList.add(createInboxRecipient(user));
        recipientList.add(createSentRecipient(userService.get(senderId)));
        return recipientList;
    }

    private Recipient createInboxRecipient(User user) {
        return RecipientBuilder.createRecipient()
                .withUserId(user.getId())
                .withFolder(folderService.getInbox(user))
                .isUnread(true)
                .isActive(true)
                .build();
    }

    private Recipient createSentRecipient(User user) {
        return RecipientBuilder.createRecipient()
                .withUserId(user.getId())
                .withFolder(folderService.getSent(user))
                .isUnread(false)
                .isActive(true)
                .build();
    }

    private Recipient getRecipient(long userId, long messageId)
            throws MessageRecipientNotFoundException {

        List<Recipient> recipients = messageDAO.getById(messageId).getRecipients();

        for (Recipient r : recipients)
            if (r.getUserId() == userId)
                return r;

        throw new MessageRecipientNotFoundException();
    }
}
