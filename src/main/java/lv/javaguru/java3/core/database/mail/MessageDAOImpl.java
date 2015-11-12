package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.mail.Message;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Andrew on 10.11.2015.
 */
@Component
public class MessageDAOImpl extends CRUDOperationDAOImpl<Message, Long> implements MessageDAO {

    @Override
    public void create(Message entity) {
        entity.setCreated(new Date());
        getCurrentSession().saveOrUpdate(entity);
    }

    /*
    @Override
    public void delete(Message entity) {
        entity.setIsActive(false);
        getCurrentSession().update(entity);
    }
    */
}
