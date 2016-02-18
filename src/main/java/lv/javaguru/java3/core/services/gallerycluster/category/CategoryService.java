package lv.javaguru.java3.core.services.gallerycluster.category;

import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryDTO;

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

    CategoryDTO updateDTO(CategoryDTO categoryDTO);

    Category update(CategoryDTO categoryDTO);

    Category get(Long id);

    CategoryDTO getCategoryImagesLimited(Long id, int page, int size);

    CategoryDTO getCategoryImagesSmall(Long id, int page);

    void delete(long id);
}
