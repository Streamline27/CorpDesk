package lv.javaguru.java3.core.services.gallery_cluster.category;

import lv.javaguru.java3.core.domain.gallery_cluster.category.Category;
import lv.javaguru.java3.core.dto.gallery_cluster.CategoryDTO;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface CategoryFactory {

    Category create(long galleryId,
                    long imgId,
                    String label,
                    String description,
                    boolean isActive,
                    boolean allowRate,
                    boolean allowRateIcons,
                    Date modified);

    CategoryDTO create(CategoryDTO categoryDTO);
}
