package lv.javaguru.java3.core.database.gallerycluster.category;

import lv.javaguru.java3.core.database.CRUDOperationDAO;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryPageDTO;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface CategoryDAO extends CRUDOperationDAO<Category, Long> {
    List<CategoryPageDTO> findAllWithPaginationAndThumbs(Long galleryId, int page, int size);
    Long categoryCount(Long galleryId);
}
