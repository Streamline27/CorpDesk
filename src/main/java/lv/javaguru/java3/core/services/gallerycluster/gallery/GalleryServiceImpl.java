package lv.javaguru.java3.core.services.gallerycluster.gallery;

import lv.javaguru.java3.core.convertor.GalleryConverter;
import lv.javaguru.java3.core.database.gallerycluster.gallery.GalleryDAO;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
@Service
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
    public List<Gallery> getAll() {
        return  galleryDAO.getAll();
    }


    @Override
    public GalleryDTO updateDTO(GalleryDTO galleryDTO) {
        galleryValidator.validate(galleryDTO);
        galleryDAO.update(galleryConverter.convert(galleryDTO));
        return galleryDTO;
    }
    @Override
    public Gallery update(GalleryDTO galleryDTO) {
        galleryValidator.validate(galleryDTO);
        Gallery gallery = galleryConverter.convert(galleryDTO);
        galleryDAO.update(gallery);
        return gallery;
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
