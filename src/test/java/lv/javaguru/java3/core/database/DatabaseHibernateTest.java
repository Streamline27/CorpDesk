package lv.javaguru.java3.core.database;

import lv.javaguru.java3.config.AppCoreConfig;
import lv.javaguru.java3.core.database.client.ClientDAO;
import lv.javaguru.java3.core.database.user.GroupDAO;
import lv.javaguru.java3.core.database.user.UserDAO;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppCoreConfig.class})
@TransactionConfiguration(transactionManager = "hibernateTX", defaultRollback = true)
public abstract class DatabaseHibernateTest {

	@Autowired
	protected SessionFactory sessionFactory;

	@Autowired
	protected ClientDAO clientDAO;

	@Autowired
	protected UserDAO userDAO;

	@Autowired
	protected GroupDAO groupDAO;
}
