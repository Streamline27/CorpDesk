package lv.javaguru.java3.core.commands.gallery_cluster.converter;


import lv.javaguru.java3.core.domain.gallery_cluster.gallery.Gallery;
import static lv.javaguru.java3.core.domain.gallery_cluster.gallery.GalleryBuilder.aGallery;
import lv.javaguru.java3.core.dto.gallery_cluster.GalleryDTO;

import static lv.javaguru.java3.core.dto.gallery_cluster.GalleryDTOBuilder.aGalleryDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GalleryConverter {

    public GalleryDTO convert(Gallery gallery){
        if (gallery == null) return null;
        return aGalleryDTO()
                .withUserId(gallery.getUserId())
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
                .withUserId(galleryDTO.getUserId())
                .withAllowRate(galleryDTO.getAllowRate())
                .withAllowRateIcons(galleryDTO.getAllowRateIcons())
                .withDescription(galleryDTO.getDescription())
                .withIsActive(galleryDTO.isActive())
                .withLabel(galleryDTO.getLabel())
                .build();
    }
}
