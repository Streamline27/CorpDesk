package lv.javaguru.java3.core.database;

import lv.javaguru.java3.config.AppCoreConfig;
import lv.javaguru.java3.core.database.client.ClientDAO;
import lv.javaguru.java3.core.database.mail.FolderCategoryDAO;
import lv.javaguru.java3.core.database.mail.FolderDAO;
import lv.javaguru.java3.core.database.mail.MessageDAO;
import lv.javaguru.java3.core.database.mail.RecipientDAO;
import lv.javaguru.java3.core.database.post.CommentDAO;
import lv.javaguru.java3.core.database.post.PostDAO;
import lv.javaguru.java3.core.database.user.GroupDAO;
import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.database.user.UserLogDAO;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;


@Component
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppCoreConfig.class})
@TransactionConfiguration(defaultRollback=true)
public abstract class DatabaseHibernateTest {

	@Autowired
	protected SessionFactory sessionFactory;

	@Autowired
	protected ClientDAO clientDAO;

	@Autowired
	protected UserDAO userDAO;

	@Autowired
	protected GroupDAO groupDAO;

    @Autowired
    protected PostDAO postDAO;

    @Autowired
    protected CommentDAO commentDAO;

	@Autowired
	protected UserLogDAO userLogDAO;

	@Autowired
	protected MessageDAO messageDAO;

	@Autowired
	protected RecipientDAO recipientDAO;

	@Autowired
	protected FolderDAO folderDAO;

	@Autowired
	protected FolderCategoryDAO folderCategoryDAO;

}
