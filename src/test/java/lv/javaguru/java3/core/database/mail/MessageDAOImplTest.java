package lv.javaguru.java3.core.database.mail;


import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.mail.Message;
import lv.javaguru.java3.core.domain.mail.Recipient;
import lv.javaguru.java3.core.domain.user.User;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.domain.mail.MessageBuilder.createMessage;
import static lv.javaguru.java3.core.domain.mail.RecipientBuilder.createRecipient;
import static lv.javaguru.java3.core.domain.user.RoleBuilder.createRole;
import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;
import static org.junit.Assert.assertTrue;

@Transactional
public class MessageDAOImplTest extends DatabaseHibernateTest {

    private Message message1;
    private Message message2;
    private User user1;
    private User user2;
    // private Folder folder;
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
        recipient1 = createRecipient()
                .withUser(user2)
                        //  .withFolder()
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
                .withUser(user1)
                        //  .withFolder()
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

        messageDAO.create(message1);
        messageDAO.create(message2);

        assertTrue(message1.equals(messageDAO.getById(message1.getId())));
        assertTrue(message2.equals(messageDAO.getById(message2.getId())));
    }
}
