package lv.javaguru.java3.core.convertor;


import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import static lv.javaguru.java3.core.domain.gallerycluster.gallery.GalleryBuilder.aGallery;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.dto.gallerycluster.GalleryDTOBuilder.aGalleryDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
@Component
public class GalleryConverter {

    public GalleryDTO convert(Gallery gallery){
        if (gallery == null) return null;
        return aGalleryDTO()
                .withUserId(gallery.getId())
                .withAllowRate(gallery.getAllowRate())
                .withAllowRateIcons(gallery.getAllowRateIcons())
                .withDescription(gallery.getDescription())
                .withIsActive(gallery.isActive())
                .withLabel(gallery.getLabel())
                .build();
    }
    public Gallery convert(GalleryDTO galleryDTO){
        if (galleryDTO == null) return null;
        return aGallery()
             //   .withUserId(galleryDTO.getUserId())
                .withAllowRate(galleryDTO.getAllowRate())
                .withAllowRateIcons(galleryDTO.getAllowRateIcons())
                .withDescription(galleryDTO.getDescription())
                .withIsActive(galleryDTO.isActive())
                .withLabel(galleryDTO.getLabel())
                .build();
    }
}
