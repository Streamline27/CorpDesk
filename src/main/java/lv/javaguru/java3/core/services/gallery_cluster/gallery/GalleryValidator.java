package lv.javaguru.java3.core.services.gallery_cluster.gallery;


import lv.javaguru.java3.core.dto.gallery_cluster.GalleryDTO;

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
}
