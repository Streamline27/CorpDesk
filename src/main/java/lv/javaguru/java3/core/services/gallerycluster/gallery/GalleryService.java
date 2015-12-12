package lv.javaguru.java3.core.services.gallerycluster.gallery;

import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface GalleryService {
    Gallery update(long newGalleryId,
                   String newLabel,
                   String newDescription,
                   boolean newIsActive,
                   boolean newAllowRate,
                   boolean newAllowRateIcons);

    GalleryDTO update(GalleryDTO galleryDTO);

    Gallery update(Gallery gallery);

    Gallery get(Long id);

    void delete(long id);
}
