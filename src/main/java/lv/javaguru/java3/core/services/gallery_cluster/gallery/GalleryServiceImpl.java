package lv.javaguru.java3.core.services.gallery_cluster.gallery;

import lv.javaguru.java3.core.database.gallery_cluster.gallery.GalleryDAO;
import lv.javaguru.java3.core.domain.gallery_cluster.gallery.Gallery;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class GalleryServiceImpl implements GalleryService {

    @Autowired private GalleryValidator galleryValidator;
    @Autowired private GalleryDAO galleryDAO;

    @Override
    public Gallery update(long galleryId,
                          String newLabel,
                          String newDescription,
                          boolean newIsActive,
                          boolean newAllowRate,
                          boolean newAllowRateIcons) {
           galleryValidator.validate(newLabel,
                   newDescription,
                   newIsActive,
                   newAllowRate,
                   newAllowRateIcons);

        Gallery gallery = get(galleryId);
        gallery.setLabel(newLabel);
        gallery.setDescription(newDescription);
        gallery.setIsActive(newIsActive);
        gallery.setAllowRate(newAllowRate);
        gallery.setAllowRateIcons(newAllowRateIcons);
        return gallery;
    }

    @Override
    public Gallery get(Long id) {
        return  galleryDAO.getRequired(id);
    }
}
