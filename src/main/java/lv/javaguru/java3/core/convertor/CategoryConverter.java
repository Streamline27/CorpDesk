package lv.javaguru.java3.core.convertor;

import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import static lv.javaguru.java3.core.domain.gallerycluster.category.CategoryBuilder.aCategory;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.dto.gallerycluster.CategoryDTOBuilder.aCategoryDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
@Component
public class CategoryConverter {
  //  @Autowired
   // private

    public CategoryDTO convert(Category category){
        if (category == null) return null;
        return aCategoryDTO()
                .withId(category.getId())
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
                .withId(categoryDTO.getId())
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

    public List<CategoryDTO> convert(List<Category> categories) {
        List<CategoryDTO> result = new ArrayList<>();
        if (categories!=null)
            for (Category category: categories)
                result.add(convert(category));
        return result;
    }
    public List<Category> convertDTO(List<CategoryDTO> categoryDTOs) {
        List<Category> result = new ArrayList<>();
        if (categoryDTOs!=null)
            for (CategoryDTO categoryDTO: categoryDTOs)
                result.add(convert(categoryDTO));
        return result;
    }

}
