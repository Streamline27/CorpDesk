package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.mail.FolderCategory;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 15.11.2015.
 */

@Component
public class FolderCategoryDAOImpl extends CRUDOperationDAOImpl<FolderCategory, Long> implements FolderCategoryDAO {
}
