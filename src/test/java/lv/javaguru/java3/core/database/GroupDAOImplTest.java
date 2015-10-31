package lv.javaguru.java3.core.database;

import lv.javaguru.java3.core.database.user.GroupDAO;
import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.domain.user.Group;
import lv.javaguru.java3.core.domain.user.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

import static lv.javaguru.java3.core.domain.user.RoleBuilder.createRole;
import static lv.javaguru.java3.core.domain.user.GroupBuilder.createGroup;
import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class GroupDAOImplTest extends DatabaseHibernateTest {

    @Autowired
    protected UserDAO userDAO;

    @Autowired
    protected GroupDAO groupDAO;

    private Group group;
    private Group group2;

    @Before
    public void init()  {
        group = createGroup()
                .withName("All")
                .build();
        group2 = createGroup()
                .withName("Managers")
                .build();
    }

    @Test
    public void testCreateGroup() {
        assertEquals(0, group.getId());
        groupDAO.create(group);

        assertThat(group.getId(), is(notNullValue()));
        assertThat(group.getLastModified(), is(notNullValue()));

        Group groupFromDB = groupDAO.getById(group.getId());
        assertEquals(group.getName(), groupFromDB.getName());
        assertEquals(group.getLastModified(), groupFromDB.getLastModified());
    }

   /* @Test
    public void testCreateUserWithGroup() {

        groupDAO.create(group);
        List<Group> groups = Collections.singletonList(group);
        User user = createUser()
                .withLogin("userrrrr")
                .withPassword("encryptedPassword")
                .withUserRole(createRole().admin().build())
                .withFirstName("dima")
                .withLastName("pavlov")
                .withGroups(groups)
                .build();
        userDAO.create(user);

        Group groupFromDB = groupDAO.getById(group.getId());
        //User userFromDB = userDAO.getById(user.getId());
        assertEquals(1, groupFromDB.getUsers().size());
        assertEquals(user.getId(), groupFromDB.getUsers().get(0).getId());
        assertTrue(user.getLogin().equals(groupFromDB.getUsers().get(0).getLogin()));
    }*/

    @Test
    public void testGetGroupById() {
        groupDAO.create(group);
        Group groupFromDb = groupDAO.getById(group.getId());
        assertThat(groupFromDb, is(notNullValue()));
    }

    @Test
    public void testMultipleGroupCreation()  {
        List<Group> groups = groupDAO.getAll();
        int groupsCount = groups==null ? 0 : groups.size();

        groupDAO.create(group);
        groupDAO.create(group2);
        groups = groupDAO.getAll();
        assertEquals(2, groups.size()-groupsCount);
    }

    @Test
    public void testDelete()  {
        List<Group> groups = groupDAO.getAll();
        int groupsCount = groups==null ? 0 : groups.size();

        groupDAO.create(group);
        groupDAO.create(group2);
        groups = groupDAO.getAll();
        assertEquals(2, groups.size()-groupsCount);

        groupDAO.delete(group);
        groups = groupDAO.getAll();
        assertEquals(1, groups.size()-groupsCount);

        groupDAO.delete(group2);
        groups = groupDAO.getAll();
        assertEquals(0, groups.size()-groupsCount);
    }


    @Test
    public void testUpdate()  {
        groupDAO.create(group);

        group = groupDAO.getById(group.getId());

        group.setName(group2.getName());

        groupDAO.update(group);

        Group groupFromDB = groupDAO.getById(group.getId());

        assertNotNull(groupFromDB);
        assertEquals(group2.getName(), groupFromDB.getName());
    }


}