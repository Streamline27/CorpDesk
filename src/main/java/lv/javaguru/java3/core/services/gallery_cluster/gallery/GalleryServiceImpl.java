package lv.javaguru.java3.core.services.gallery_cluster.gallery;

import lv.javaguru.java3.core.commands.gallery_cluster.converter.GalleryConverter;
import lv.javaguru.java3.core.database.gallery_cluster.gallery.GalleryDAO;
import lv.javaguru.java3.core.domain.gallery_cluster.gallery.Gallery;
import lv.javaguru.java3.core.dto.gallery_cluster.GalleryDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class GalleryServiceImpl implements GalleryService {

    @Autowired private GalleryValidator galleryValidator;
    @Autowired private GalleryDAO galleryDAO;
    @Autowired private GalleryConverter galleryConverter;

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

    @Override
    public GalleryDTO update(GalleryDTO galleryDTO) {
        galleryValidator.validate(galleryDTO);
        galleryDAO.update(galleryConverter.convert(galleryDTO));
        return galleryDTO;
    }

    @Override
    public void delete(long id) {
        Gallery gallery = galleryDAO.getRequired(id);
        galleryDAO.delete(gallery);
    }

    @Override
    public Gallery update(Gallery gallery) {
        galleryValidator.validate(galleryConverter.convert(gallery));
        galleryDAO.update(gallery);
        return gallery;
    }
}
