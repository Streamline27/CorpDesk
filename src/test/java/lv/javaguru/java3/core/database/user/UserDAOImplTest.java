package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.DatabaseCleaner;
import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.domain.user.Group;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;
import static lv.javaguru.java3.core.domain.user.RoleBuilder.createRole;
import static lv.javaguru.java3.core.domain.user.GroupBuilder.createGroup;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class UserDAOImplTest extends DatabaseHibernateTest {
    private User user;
    private User user2;
    private Group group;
    private Group group2;
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    @Before
    public void init() throws Exception {
        databaseCleaner.cleanDatabase();
        group = createGroup()
                .withName("All")
                .build();
        group2 = createGroup()
                .withName("None")
                .build();
        user = createUser()
                .withLogin("userrrrr")
                .withPassword("encryptedPassword")
                .withUserRole(createRole().admin().build())
                .withFirstName("dima")
                .withLastName("pavlov")
                .withEmail("dima@pavlov.lv")
                .withGroups(Collections.singletonList(group))
                .build();
        user2 = createUser()
                .withLogin("adminnnn")
                .withPassword("encryptedPassword2")
                .withUserRole(createRole().user().build())
                .withFirstName("ivan")
                .withLastName("petrov")
                .withEmail("ivan@petrov.lv")
                .build();
    }

    @Test
    @Transactional
    public void testCreateUser() {
        assertEquals(0, user.getId());
        userDAO.create(user);

        assertThat(user.getId(), is(notNullValue()));
        assertThat(user.getLastModified(), is(notNullValue()));
        assertEquals(1, user.getState().getId());

        User userFromDB = userDAO.getById(user.getId());
        assertEquals(user.getLogin(), userFromDB.getLogin());
        assertEquals(user.getPassword(), userFromDB.getPassword());
        assertEquals(user.getUserRole().getId(), userFromDB.getUserRole().getId());
        //assertTrue(userFromDB.getUserRole().getName().equals("Administrator"));
        assertEquals(user.getFirstName(), userFromDB.getFirstName());
        assertEquals(user.getLastName(), userFromDB.getLastName());
        assertEquals(user.getEmail(), userFromDB.getEmail());
        assertEquals(user.getState().getId(), userFromDB.getState().getId());
        //assertTrue(userFromDB.getState().getState().equals("Created"));
        assertEquals(user.getLastModified(), userFromDB.getLastModified());
    }

    @Test
    @Transactional
    public void testCreateUserWithGroup() {

        groupDAO.create(group);
        groupDAO.create(group2);
        List<Group> groups = Arrays.asList(group, group2);
        user = createUser()
                .withLogin("userrrrr")
                .withPassword("encryptedPassword")
                .withUserRole(createRole().admin().build())
                .withFirstName("dima")
                .withLastName("pavlov")
                .withEmail("dima@pavlov.lv")
                .withGroups(groups)
                .build();
        userDAO.create(user);

        assertTrue(user.getId()>0);

        User userFromDB = userDAO.getById(user.getId());
        assertEquals(2, userFromDB.getGroups().size());
        assertEquals(group.getId(), userFromDB.getGroups().get(0).getId());
        assertEquals(group2.getId(), userFromDB.getGroups().get(1).getId());
        assertTrue(group.getName().equals(userFromDB.getGroups().get(0).getName()));
    }

    @Test
    @Transactional
    public void testGetUserById() {
        userDAO.create(user);
        User userFromDb = userDAO.getById(user.getId());
        assertThat(userFromDb, is(notNullValue()));
    }

    @Test
    @Transactional
    public void testMultipleUserCreation()  {
        List<User> users = userDAO.getAll();
        int usersCount = users==null ? 0 : users.size();

        userDAO.create(user);
        userDAO.create(user2);
        users = userDAO.getAll();
        assertEquals(2, users.size() - usersCount);
    }

    /*
    @Test
    @Transactional
    public void testDelete()  {
        List<User> users = userDAO.getAll();
        int usersCount = users==null ? 0 : users.size();

        userDAO.create(user);
        userDAO.create(user2);
        users = userDAO.getAll();
        assertEquals(2, users.size()-usersCount);

        userDAO.delete(user);
        users = userDAO.getAll();
        assertEquals(1, users.size()-usersCount);

        userDAO.delete(user2);
        users = userDAO.getAll();
        assertEquals(0, users.size()-usersCount);
    }
*/

    @Test
    @Transactional
    public void testUpdate()  {
        userDAO.create(user);

        user = userDAO.getById(user.getId());

        user.setLogin(user2.getLogin());
        user.setPassword(user2.getPassword());
        user.setUserRole(user2.getUserRole());
        user.setFirstName(user2.getFirstName());
        user.setLastName(user2.getLastName());
        user.setEmail(user2.getEmail());

        userDAO.update(user);

        User userFromDB = userDAO.getById(user.getId());

        assertNotNull(userFromDB);
        assertEquals(user2.getLogin(), userFromDB.getLogin());
        assertEquals(user2.getPassword(), userFromDB.getPassword());
        assertEquals(user2.getUserRole().getId(), userFromDB.getUserRole().getId());
        assertEquals(user2.getFirstName(), userFromDB.getFirstName());
        assertEquals(user2.getLastName(), userFromDB.getLastName());
        assertEquals(user2.getEmail(), userFromDB.getEmail());
    }


}