package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.user.Group;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.List;

import static lv.javaguru.java3.core.domain.user.GroupBuilder.createGroup;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class GroupDAOImplTest extends DatabaseHibernateTest {

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
    @Transactional
    public void testCreateGroup() {
        assertEquals(0, group.getId());
        groupDAO.create(group);

        assertTrue(group.getId() > 0);

        assertThat(group.getId(), is(notNullValue()));
        assertThat(group.getLastModified(), is(notNullValue()));

        Group groupFromDB = groupDAO.getById(group.getId());
        assertEquals(group.getName(), groupFromDB.getName());
        assertEquals(group.getLastModified(), groupFromDB.getLastModified());
    }

   /* @Test
   @Transactional
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
    @Transactional
    public void testGetGroupById() {
        groupDAO.create(group);
        Group groupFromDb = groupDAO.getById(group.getId());
        assertThat(groupFromDb, is(notNullValue()));
    }

    @Test
    @Transactional
    @Ignore
    public void testMultipleGroupCreation()  {
        List<Group> groups = groupDAO.getAll();
        int groupsCount = groups==null ? 0 : groups.size();

        groupDAO.create(group);
        groupDAO.create(group2);
        groups = groupDAO.getAll();
        assertEquals(2, groups.size()-groupsCount);
    }

    @Test
    @Transactional
    @Ignore
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
    @Transactional
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