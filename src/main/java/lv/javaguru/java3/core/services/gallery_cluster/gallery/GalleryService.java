package lv.javaguru.java3.core.services.gallery_cluster.gallery;

import lv.javaguru.java3.core.domain.gallery_cluster.gallery.Gallery;
import lv.javaguru.java3.core.dto.gallery_cluster.GalleryDTO;

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
