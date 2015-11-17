package lv.javaguru.java3.core.services.gallery_cluster.category;

import lv.javaguru.java3.core.domain.gallery_cluster.category.Category;
import lv.javaguru.java3.core.dto.gallery_cluster.CategoryDTO;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface CategoryService {
    Category update(Long id,
                    long newImgId,
                    String newLabel,
                    String newDescription,
                    boolean newIsActive,
                    boolean newAllowRate,
                    boolean newAllowRateIcons,
                    Date newModified);
    Category update(Category category);

    CategoryDTO update(CategoryDTO categoryDTO);

    Category get(Long id);

    void delete(long id);
}
