package lv.javaguru.java3.core.services.gallery_cluster.gallery;

import lv.javaguru.java3.core.domain.gallery_cluster.gallery.Gallery;

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

    Gallery get(Long id);
}
