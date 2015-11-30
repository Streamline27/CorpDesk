package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.CRUDOperationDAO;
import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.Message;
import lv.javaguru.java3.core.domain.mail.Recipient;
import lv.javaguru.java3.core.domain.user.User;

import java.util.List;

/**
 * Created by Andrew on 10.11.2015.
 */
public interface MessageDAO extends CRUDOperationDAO<Message, Long>{

}
