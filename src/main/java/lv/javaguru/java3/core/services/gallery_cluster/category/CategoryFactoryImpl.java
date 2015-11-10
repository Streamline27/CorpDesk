package lv.javaguru.java3.core.services.gallery_cluster.category;

import lv.javaguru.java3.core.database.gallery_cluster.category.CategoryDAO;
import lv.javaguru.java3.core.domain.gallery_cluster.category.Category;
import static lv.javaguru.java3.core.domain.gallery_cluster.category.CategoryBuilder.aCategory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */

public class CategoryFactoryImpl implements CategoryFactory {

    @Autowired private CategoryValidator categoryValidator;
    @Autowired private CategoryDAO categoryDAO;

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
                .withImgId(imgId)
                .withGalleryId(galleryId)
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
}
