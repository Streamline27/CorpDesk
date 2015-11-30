package lv.javaguru.java3.core.database.mail;


import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.Message;
import lv.javaguru.java3.core.domain.mail.Recipient;
import lv.javaguru.java3.core.domain.user.User;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.*;

import static lv.javaguru.java3.core.domain.mail.FolderBuilder.createFolder;
import static lv.javaguru.java3.core.domain.mail.FolderCategoryBuilder.createFolderCategory;
import static lv.javaguru.java3.core.domain.mail.MessageBuilder.createMessage;
import static lv.javaguru.java3.core.domain.mail.RecipientBuilder.createRecipient;
import static lv.javaguru.java3.core.domain.user.RoleBuilder.createRole;
import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Transactional
public class MessageDAOImplTest extends DatabaseHibernateTest {

    private Message message1;
    private Message message2;
    private User user1;
    private User user2;
    private Folder folder1;
    private Folder folder2;
    private Recipient recipient1;
    private List<Recipient> recipients1;
    private Recipient recipient2;
    private List<Recipient> recipients2;

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
                .withCategory(createFolderCategory().custom().build())
                .withName("User 1 Folder")
                .withUserId(user1.getId())
                .build();
        folder2 = createFolder()
                .withCategory(createFolderCategory().custom().build())
                .withName("User 2 Folder")
                .withUserId(user2.getId())
                .build();

        recipient1 = createRecipient()
                .withUserId(user2.getId())
                .withFolder(folder2)
                .build();
        recipients1 = new ArrayList<>();
        recipients1.add(recipient1);
        message1 = createMessage()
                .withSender(user1)
                .withTitle("Test Message 1")
                .withBody("Hello User Two from User One!")
                .withRecipients(recipients1)
                .build();
        recipient2 = createRecipient()
                .withUserId(user1.getId())
                .withFolder(folder1)
                .build();
        recipients2 = new ArrayList<>();
        recipients2.add(recipient2);
        message2 = createMessage()
                .withSender(user2)
                .withTitle("Test Message 2")
                .withBody("Hello User One from User Two!")
                .withRecipients(recipients2)
                .build();

    }

    @Test
    @Transactional
    public void testMessageCreateAndGetById() {

        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        folderDAO.create(folder1);
        folderDAO.create(folder2);

        messageDAO.create(message1);
        messageDAO.create(message2);

        assertTrue(message1.equals(messageDAO.getById(message1.getId())));
        assertTrue(message2.equals(messageDAO.getById(message2.getId())));
    }

    @Test
    @Transactional
    public void testListRecipients() {

        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        folderDAO.create(folder1);
        folderDAO.create(folder2);

        recipient1.setUserId(user1.getId());
        recipient2.setUserId(user2.getId());
        messageDAO.create(message1);
        messageDAO.create(message2);

        List<Recipient> recipientList = messageDAO.getById(message1.getId()).getRecipients();

        assertEquals(1, recipientList.size());
        assertTrue(recipientList.contains(recipient1));

        recipientList = messageDAO.getById(message2.getId()).getRecipients();

        assertEquals(1, recipientList.size());
        assertTrue(recipientList.contains(recipient2));
    }

    @Test
    @Transactional
    public void testUpdate() {

        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        folderDAO.create(folder1);
        folderDAO.create(folder2);

        recipient1.setUserId(user1.getId());
        recipient2.setUserId(user2.getId());

        messageDAO.create(message1);

        message1.setTitle("Updated title");

        messageDAO.update(message1);

        assertTrue(messageDAO.getById(message1.getId()).getTitle().equals("Updated title"));
    }
}
