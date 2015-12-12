package lv.javaguru.java3.core.database.gallerycluster.gallery;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
@Component
public class GalleryDAOImpl extends CRUDOperationDAOImpl<Gallery, Long> implements GalleryDAO {
}
