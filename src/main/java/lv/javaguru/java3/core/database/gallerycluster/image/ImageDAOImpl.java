package lv.javaguru.java3.core.database.gallerycluster.image;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
@Component
public class ImageDAOImpl extends CRUDOperationDAOImpl<Image, Long> implements ImageDAO {
}
