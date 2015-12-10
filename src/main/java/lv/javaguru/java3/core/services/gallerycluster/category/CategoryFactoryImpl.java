package lv.javaguru.java3.core.services.gallerycluster.category;

import lv.javaguru.java3.core.commands.gallerycluster.converter.CategoryConverter;
import lv.javaguru.java3.core.database.gallerycluster.category.CategoryDAO;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import static lv.javaguru.java3.core.domain.gallerycluster.category.CategoryBuilder.aCategory;

import lv.javaguru.java3.core.dto.gallerycluster.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */

public class CategoryFactoryImpl implements CategoryFactory {

    @Autowired private CategoryValidator categoryValidator;
    @Autowired private CategoryDAO categoryDAO;
    @Autowired private CategoryConverter categoryConverter;

    @Override
    public Category create(long galleryId,
                           long imgId,
                           String label,
                           String description,
                           boolean isActive,
                           boolean allowRate,
                           boolean allowRateIcons,
                           Date modified) {

        categoryValidator.validate(galleryId,
                            imgId,
                            label,
                            description,
                            isActive,
                            allowRate,
                            allowRateIcons,
                            modified);

        Category category = aCategory()
             //   .withImgId(imgId)
              //  .withGalleryId(galleryId)
                .withLabel(label)
                .withDescription(description)
                .withIsActive(isActive)
                .withAllowRate(allowRate)
                .withAllowRateIcons(allowRateIcons)
                .withModified(modified)
                .build();
        categoryDAO.create(category);
        return category;
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        categoryValidator.validate(categoryDTO);
        categoryDAO.create(categoryConverter.convert(categoryDTO));
        return categoryDTO;
    }
}
