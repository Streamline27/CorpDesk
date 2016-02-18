package lv.javaguru.java3.core.services.gallerycluster.gallery;


import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryPageDTO;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface GalleryValidator {
    void validate(String label,
                  String description,
                  boolean isActive,
                  boolean allowRate,
                  boolean allowRateIcons);

    void validate(GalleryDTO galleryDTO);

    void validate(CategoryPageDTO categoryPageDTO);
}
