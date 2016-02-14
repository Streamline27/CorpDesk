package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.FolderType;
import lv.javaguru.java3.core.domain.mail.Message;
import lv.javaguru.java3.core.domain.mail.Recipient;
import lv.javaguru.java3.core.domain.user.User;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.domain.mail.FolderBuilder.createFolder;
import static lv.javaguru.java3.core.domain.mail.MessageBuilder.createMessage;
import static lv.javaguru.java3.core.domain.mail.RecipientBuilder.createRecipient;
import static lv.javaguru.java3.core.domain.user.RoleBuilder.createRole;
import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;
import static org.junit.Assert.assertEquals;

/**
 * Created by Andrew on 22.11.2015.
 */

@Transactional
public class RecipientDAOImplTest extends DatabaseHibernateTest {

    private User user1;
    private User user2;
    private Folder folder1;
    private Folder folder2;
    private Folder folder3;

    @Before
    public void init() {
        user1 = createUser()
                .withLogin("testuser1")
                .withPassword("encryptedPassword")
                .withUserRole(createRole().admin().build())
                .withFirstName("User")
                .withLastName("One")
                .withEmail("one@test.user")
                .build();
        user2 = createUser()
                .withLogin("testuser2")
                .withPassword("encryptedPassword2")
                .withUserRole(createRole().user().build())
                .withFirstName("User")
                .withLastName("Two")
                .withEmail("two@test.user")
                .build();
        folder1 = createFolder()
                .withName("User 1 Folder 1")
                .withType(FolderType.USER_CREATED)
                .withUserId(user1.getId())
                .build();
        folder2 = createFolder()
                .withName("User 2 Folder 1")
                .withType(FolderType.USER_CREATED)
                .withUserId(user2.getId())
                .build();
        folder3 = createFolder()
                .withName("User 2 Folder 2")
                .withType(FolderType.USER_CREATED)
                .withUserId(user2.getId())
                .build();
    }

    @Test
    @Transactional
    public void testGetByFolderId() {

        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        folderDAO.create(folder1);
        folderDAO.create(folder2);

        Message message1 = createMessage()
                .build();
        Message message2 = createMessage()
                .build();
        Message message3 = createMessage()
                .build();


        List<Recipient> recipients1 = new ArrayList<>();
        recipients1.add(createRecipient()
                .withUserId(user1.getId())
                .withFolder(folder1)
                .withMessageId(message1.getId())
                .isUnread(true)
                .isActive(true)
                .build());

        List<Recipient> recipients2 = new ArrayList<>();
        recipients2.add(createRecipient()
                .withUserId(user2.getId())
                .withFolder(folder2)
                .withMessageId(message2.getId())
                .isUnread(true)
                .isActive(true)
                .build());

        List<Recipient> recipients3 = new ArrayList<>();
        recipients3.add(createRecipient()
                .withUserId(user2.getId())
                .withFolder(folder2)
                .withMessageId(message3.getId())
                .isUnread(true)
                .isActive(true)
                .build());


        message1.setBody("This is test message 1");
        message1.setIsActive(true);
        message1.setRecipients(recipients1);
        message1.setIsImportant(false);
        message1.setSenderId(user2.getId());
        message1.setTitle("Test message 1");
        messageDAO.create(message1);

        message2.setBody("This is test message 2");
        message2.setIsActive(true);
        message2.setRecipients(recipients2);
        message2.setIsImportant(false);
        message2.setSenderId(user1.getId());
        message2.setTitle("Test message 2");
        messageDAO.create(message2);

        message3.setBody("This is test message 3");
        message3.setIsActive(true);
        message3.setRecipients(recipients3);
        message3.setIsImportant(false);
        message3.setSenderId(user2.getId());
        message3.setTitle("Test message 3");
        messageDAO.create(message3);


        assertEquals(1, recipientDAO.getByFolderId(folder1.getId()).size());
        assertEquals(2, recipientDAO.getByFolderId(folder2.getId()).size());

    }

    @Test
    @Transactional
    public void testGetMessagesCount() {

        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        folderDAO.create(folder1);
        folderDAO.create(folder2);

        Message message1 = createMessage()
                .build();
        Message message2 = createMessage()
                .build();
        Message message3 = createMessage()
                .build();


        List<Recipient> recipients1 = new ArrayList<>();
        recipients1.add(createRecipient()
                .withUserId(user1.getId())
                .withFolder(folder1)
                .withMessageId(message1.getId())
                .isUnread(true)
                .isActive(true)
                .build());

        List<Recipient> recipients2 = new ArrayList<>();
        recipients2.add(createRecipient()
                .withUserId(user2.getId())
                .withFolder(folder2)
                .withMessageId(message2.getId())
                .isUnread(true)
                .isActive(true)
                .build());

        List<Recipient> recipients3 = new ArrayList<>();
        recipients3.add(createRecipient()
                .withUserId(user2.getId())
                .withFolder(folder2)
                .withMessageId(message3.getId())
                .isUnread(true)
                .isActive(true)
                .build());


        message1.setBody("This is test message 1");
        message1.setIsActive(true);
        message1.setRecipients(recipients1);
        message1.setIsImportant(false);
        message1.setSenderId(user2.getId());
        message1.setTitle("Test message 1");
        messageDAO.create(message1);

        message2.setBody("This is test message 2");
        message2.setIsActive(true);
        message2.setRecipients(recipients2);
        message2.setIsImportant(false);
        message2.setSenderId(user1.getId());
        message2.setTitle("Test message 2");
        messageDAO.create(message2);

        message3.setBody("This is test message 3");
        message3.setIsActive(true);
        message3.setRecipients(recipients3);
        message3.setIsImportant(false);
        message3.setSenderId(user1.getId());
        message3.setTitle("Test message 3");
        messageDAO.create(message3);


        message3.getId();
        assertEquals(1, recipientDAO.getMessagesCount(folder1.getId()));
        assertEquals(2, recipientDAO.getMessagesCount(folder2.getId()));

    }

    @Test
    @Transactional
    public void testUnreadMessageCount() {

        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        folderDAO.create(folder1);
        folderDAO.create(folder2);


        Message message1 = createMessage()
                .build();
        Message message2 = createMessage()
                .build();


        List<Recipient> recipients1 = new ArrayList<>();
        recipients1.add(createRecipient()
                .withUserId(user1.getId())
                .withFolder(folder1)
                .withMessageId(message1.getId())
                .isUnread(false)
                .isActive(true)
                .build());

        List<Recipient> recipients2 = new ArrayList<>();
        recipients2.add(createRecipient()
                .withUserId(user2.getId())
                .withFolder(folder2)
                .withMessageId(message2.getId())
                .isUnread(true)
                .isActive(true)
                .build());


        message1.setBody("This is test message 1");
        message1.setIsActive(true);
        message1.setRecipients(recipients1);
        message1.setIsImportant(false);
        message1.setSenderId(user2.getId());
        message1.setTitle("Test message 1");
        messageDAO.create(message1);

        message2.setBody("This is test message 2");
        message2.setIsActive(true);
        message2.setRecipients(recipients2);
        message2.setIsImportant(false);
        message2.setSenderId(user1.getId());
        message2.setTitle("Test message 2");
        messageDAO.create(message2);


        assertEquals(0, recipientDAO.getUnreadMessageCount(folder1.getId()));
        assertEquals(1, recipientDAO.getUnreadMessageCount(folder2.getId()));

    }

}
