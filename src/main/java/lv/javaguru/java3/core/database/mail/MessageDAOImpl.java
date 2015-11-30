package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.database.mail.exception.IllegalOperationException;
import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.Message;
import lv.javaguru.java3.core.domain.mail.Recipient;
import lv.javaguru.java3.core.domain.user.User;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Andrew on 10.11.2015.
 */
@Component
public class MessageDAOImpl extends CRUDOperationDAOImpl<Message, Long> implements MessageDAO {

    @Override
    public void create(Message message) {
        message.setCreated(new Date());

        getCurrentSession().saveOrUpdate(message);
    }

}
