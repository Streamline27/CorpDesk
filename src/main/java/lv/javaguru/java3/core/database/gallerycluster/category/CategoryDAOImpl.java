package lv.javaguru.java3.core.database.gallerycluster.category;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
@Component
public class CategoryDAOImpl  extends CRUDOperationDAOImpl<Category, Long> implements CategoryDAO {
}
