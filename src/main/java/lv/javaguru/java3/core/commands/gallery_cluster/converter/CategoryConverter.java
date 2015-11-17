package lv.javaguru.java3.core.commands.gallery_cluster.converter;

import lv.javaguru.java3.core.domain.gallery_cluster.category.Category;
import static lv.javaguru.java3.core.domain.gallery_cluster.category.CategoryBuilder.aCategory;
import lv.javaguru.java3.core.dto.gallery_cluster.CategoryDTO;
import static lv.javaguru.java3.core.dto.gallery_cluster.CategoryDTOBuilder.aCategoryDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class CategoryConverter {

    public CategoryDTO convert(Category category){
        if (category == null) return null;
        return aCategoryDTO()
                .withId(category.getId())
                .withImgId(category.getImgId())
                .withGalleryId(category.getGalleryId())
                .withIsActive(category.isActive())
                .withLabel(category.getLabel())
                .withModified(category.getModifed())
                .withAllowRate(category.getAllowRate())
                .withAllowRateIcons(category.getAllowRateIcons())
                .withDescription(category.getDescription())
                .build();
    }
    public Category convert(CategoryDTO categoryDTO){
        if (categoryDTO == null) return null;
        return aCategory()
                .withId(categoryDTO.getId())
                .withImgId(categoryDTO.getImgId())
                .withGalleryId(categoryDTO.getGalleryId())
                .withIsActive(categoryDTO.isActive())
                .withLabel(categoryDTO.getLabel())
                .withModified(categoryDTO.getModifed())
                .withAllowRate(categoryDTO.getAllowRate())
                .withAllowRateIcons(categoryDTO.getAllowRateIcons())
                .withDescription(categoryDTO.getDescription())
                .build();
    }

}
