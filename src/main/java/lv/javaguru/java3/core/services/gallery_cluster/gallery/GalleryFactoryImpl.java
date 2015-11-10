package lv.javaguru.java3.core.services.gallery_cluster.gallery;

import lv.javaguru.java3.core.database.gallery_cluster.gallery.GalleryDAO;
import lv.javaguru.java3.core.domain.gallery_cluster.gallery.Gallery;
import static lv.javaguru.java3.core.domain.gallery_cluster.gallery.GalleryBuilder.aGallery;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class GalleryFactoryImpl implements GalleryFactory{

    @Autowired private GalleryValidator galleryValidator;
    @Autowired private GalleryDAO galleryDAO;

    @Override
    public Gallery create(String label,
                          String description,
                          boolean isActive,
                          boolean allowRate,
                          boolean allowRateIcons) {
        galleryValidator.validate(label,
                description,
                isActive,
                allowRate,
                allowRateIcons
                );
        Gallery gallery = aGallery()
                .withLabel(label)
                .withDescription(description)
                .withIsActive(isActive)
                .withAllowRate(allowRate)
                .withAllowRateIcons(allowRateIcons)
                .build();
        galleryDAO.create(gallery);
        return gallery;
    }
}
