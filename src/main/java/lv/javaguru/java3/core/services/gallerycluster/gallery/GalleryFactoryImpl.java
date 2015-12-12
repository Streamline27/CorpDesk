package lv.javaguru.java3.core.services.gallerycluster.gallery;

import lv.javaguru.java3.core.commands.gallerycluster.converter.GalleryConverter;
import lv.javaguru.java3.core.database.gallerycluster.gallery.GalleryDAO;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import static lv.javaguru.java3.core.domain.gallerycluster.gallery.GalleryBuilder.aGallery;

import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class GalleryFactoryImpl implements GalleryFactory{

    @Autowired private GalleryValidator galleryValidator;
    @Autowired private GalleryDAO galleryDAO;
    @Autowired private GalleryConverter galleryConverter;

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

    @Override
    public GalleryDTO create(GalleryDTO galleryDTO) {

        galleryValidator.validate(galleryDTO);
        galleryDAO.create(galleryConverter.convert(galleryDTO));
        return galleryDTO;
    }
}
