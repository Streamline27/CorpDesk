package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.FolderType;
import lv.javaguru.java3.core.domain.user.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import java.util.List;

import static lv.javaguru.java3.core.domain.mail.FolderBuilder.createFolder;
import static lv.javaguru.java3.core.domain.user.RoleBuilder.createRole;
import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Andrew on 15.11.2015.
 */

@Transactional
public class FolderDAOImplTest extends DatabaseHibernateTest {

    private User user1;
    private User user2;
    private Folder folder1;
    private Folder folder2;
    private Folder folder3;

    @Autowired private MessageDAO messageDAO;

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
    public void testCreateFolder() {

        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        assertEquals(0, folder1.getId());
        folderDAO.create(folder1);

        assertThat(folder1.getId(), is(notNullValue()));
        assertThat(folder1.getFolderType(), is(notNullValue()));
        assertThat(folder1.getName(), is(notNullValue()));
        assertThat(folder1.getUserId(), is(notNullValue()));

        Folder folderFromDB = folderDAO.getById(folder1.getId());
        assertTrue(folder1.equals(folderFromDB));
    }

    @Test
    @Transactional
    public void testGetById() {
        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        folderDAO.create(folder1);
        Folder groupFromDb = folderDAO.getById(folder1.getId());
        assertThat(groupFromDb, is(notNullValue()));
    }

    @Test
    @Transactional
    @Ignore
    public void testDelete()  {
        List<Folder> folders = folderDAO.getAll();
        int folderCount = folders == null ? 0 : folders.size();

        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        folderDAO.create(folder1);
        folderDAO.create(folder2);
        folders = folderDAO.getAll();
        assertEquals(2, folders.size() - folderCount);

        folderDAO.delete(folder1);
        folders = folderDAO.getAll();
        assertEquals(1, folders.size() - folderCount);

        folderDAO.delete(folder2);
        folders = folderDAO.getAll();
        assertEquals(0, folders.size() - folderCount);
    }

    @Test
    @Transactional
    public void testUpdate()  {

        userDAO.create(user1);

        folder1.setUserId(user1.getId());
        folderDAO.create(folder1);

        folder1 = folderDAO.getById(folder1.getId());

        folder1.setName(folder2.getName());

        folderDAO.update(folder1);

        Folder folderFromDB = folderDAO.getById(folder1.getId());

        assertNotNull(folderFromDB);
        assertEquals(folder2.getName(), folderFromDB.getName());
    }

    @Test
    @Transactional
    public void testGetByUser() {

        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        folder3.setUserId(user2.getId());
        folderDAO.create(folder1);
        folderDAO.create(folder2);
        folderDAO.create(folder3);

        List<Folder> folderListFromDB = folderDAO.listByUserId(user1.getId());
        assertEquals(1, folderListFromDB.size());
        assertTrue(folderListFromDB.contains(folder1));

        folderListFromDB = folderDAO.listByUserId(user2.getId());
        assertEquals(2, folderListFromDB.size());
        assertTrue(folderListFromDB.contains(folder2));
        assertTrue(folderListFromDB.contains(folder3));
    }

    @Test
    @Transactional
    public void testExistingFolderGetByCategory() {
        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        folder2.setFolderType(FolderType.INBOX);

        folderDAO.create(folder2);
        folder3.setUserId(user2.getId());
        folderDAO.create(folder3);

        assertEquals(folder2, folderDAO.getByType(user2.getId(), FolderType.INBOX));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    @Transactional
    public void testNonExistingFolderGetByCategory() {
        userDAO.create(user1);
        userDAO.create(user2);

        folder1.setUserId(user1.getId());
        folder2.setUserId(user2.getId());
        folder3.setUserId(user2.getId());
        folder2.setFolderType(FolderType.INBOX);

        folderDAO.create(folder2);
        folderDAO.create(folder3);

        folderDAO.getByType(user2.getId(), FolderType.SENT);

    }
}
