package lv.javaguru.java3.core.convertor;


import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import static lv.javaguru.java3.core.domain.gallerycluster.gallery.GalleryBuilder.aGallery;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.dto.gallerycluster.GalleryDTOBuilder.aGalleryDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
@Component
public class GalleryConverter extends Converter{
    @Autowired
    private CategoryConverter categoryConverter;

    public GalleryDTO convert(Gallery gallery){
        if (gallery == null) return null;
        return aGalleryDTO()
                .withUserId(gallery.getId())
                .withAllowRate(gallery.getAllowRate())
                .withAllowRateIcons(gallery.getAllowRateIcons())
                .withDescription(gallery.getDescription())
                .withIsActive(gallery.isActive())
                .withLabel(gallery.getLabel())
                .withCategories(categoryConverter.convert(
                        (List<Category>)ifProxyDoNotInitialize(gallery.getCategories())
                    )
                )
                .build();
    }
    public Gallery convert(GalleryDTO galleryDTO){
        if (galleryDTO == null) return null;
        return aGallery()
                .withId(galleryDTO.getUserId())
                .withAllowRate(galleryDTO.getAllowRate())
                .withAllowRateIcons(galleryDTO.getAllowRateIcons())
                .withDescription(galleryDTO.getDescription())
                .withIsActive(galleryDTO.isActive())
                .withLabel(galleryDTO.getLabel())
                .withCategories(categoryConverter.convertDTO(
                        galleryDTO.getCategoryDTOs()
                ))
                .build();
    }
  /* private List<Category> ifProxy(List<Category> categories){
            Object obj = ifProxyDoNotInitialize(categories);
            if (obj != null){
                System.out.println("No proxy");
            }else{
                System.out.println("Proxy, do not initialize");
            }
       return (List<Category>)obj;

   }*/



}
