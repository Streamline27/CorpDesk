package lv.javaguru.java3.core.services.gallerycluster.gallery;

import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface GalleryFactory {
    Gallery create( String label,
                    String description,
                    boolean isActive,
                    boolean allowRate,
                    boolean allowRateIcons);
    GalleryDTO create(GalleryDTO galleryDTO);
}
