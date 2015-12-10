package lv.javaguru.java3.core.commands.gallerycluster.converter;

import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import static lv.javaguru.java3.core.domain.gallerycluster.category.CategoryBuilder.aCategory;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryDTO;
import static lv.javaguru.java3.core.dto.gallerycluster.CategoryDTOBuilder.aCategoryDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class CategoryConverter {

    public CategoryDTO convert(Category category){
        if (category == null) return null;
        return aCategoryDTO()
               // .withId(category.getId())
               // .withImgId(category.getImgId())
              //  .withGalleryId(category.getGalleryId())
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
              //  .withId(categoryDTO.getId())
              //  .withImgId(categoryDTO.getImgId())
              //  .withGalleryId(categoryDTO.getGalleryId())
                .withIsActive(categoryDTO.isActive())
                .withLabel(categoryDTO.getLabel())
                .withModified(categoryDTO.getModifed())
                .withAllowRate(categoryDTO.getAllowRate())
                .withAllowRateIcons(categoryDTO.getAllowRateIcons())
                .withDescription(categoryDTO.getDescription())
                .build();
    }

}
