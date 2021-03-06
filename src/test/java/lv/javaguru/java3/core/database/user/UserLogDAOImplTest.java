package lv.javaguru.java3.core.database.user;

import lv.javaguru.java3.core.database.DatabaseCleaner;
import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.user.UserLog;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static lv.javaguru.java3.core.domain.user.UserLogBuilder.createUserLog;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class UserLogDAOImplTest extends DatabaseHibernateTest {

    private UserLog userLog;
    private UserLog userLog2;
    private UserLog userLog3;
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    @Before
    public void init() throws Exception {
        databaseCleaner.cleanDatabase();
        userLog = createUserLog()
                .withUserId(1).withSuccess(true).withAccessTime(new Date())
                .build();
        userLog2 = createUserLog()
                .withUserId(1).withSuccess(true).withAccessTime(new Date())
                .build();
        userLog3 = createUserLog()
                .withUserId(3).withSuccess(true).withAccessTime(new Date())
                .build();
    }

    @Test
    @Transactional
    public void testCreateUserLog() {
        userLogDAO.create(userLog);

        assertTrue(userLog.getId() > 0);

        assertThat(userLog.getId(), is(notNullValue()));

        UserLog userLogFromDB = userLogDAO.getById(userLog.getId());
        assertEquals(userLog.getSuccess(), userLogFromDB.getSuccess());
    }

    @Test
    @Transactional
    public void testGetUserLogById() {
        userLogDAO.create(userLog);
        UserLog userLogFromDb = userLogDAO.getById(userLog.getId());
        assertThat(userLogFromDb, is(notNullValue()));
    }

    @Test
    @Ignore
    @Transactional
    public void testMultipleUserLogCreation()  {
        List<UserLog> userLogs = userLogDAO.getAll();
        int userLogsCount = userLogs==null ? 0 : userLogs.size();
        List<UserLog> userLogs1 = userLogDAO.getAll((long) 1);
        int userLogsCount1 = userLogs1==null ? 0 : userLogs1.size();

        userLogDAO.create(userLog);
        userLogDAO.create(userLog2);
        userLogDAO.create(userLog3);
        userLogs = userLogDAO.getAll();
        assertEquals(3, userLogs.size()-userLogsCount);

        userLogs1 = userLogDAO.getAll((long) 1);
        assertEquals(2, userLogs1.size()-userLogsCount1);
    }

}