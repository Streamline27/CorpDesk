package lv.javaguru.java3.core.services.gallery_cluster.category;

import lv.javaguru.java3.core.database.gallery_cluster.category.CategoryDAO;
import lv.javaguru.java3.core.domain.gallery_cluster.category.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class CategoryServiceImpl implements CategoryService {

    @Autowired private CategoryValidator categoryValidator;
    @Autowired private CategoryDAO categoryDAO;

    @Override
    public Category update(Long id,
                           long newImgId,
                           String newLabel,
                           String newDescription,
                           boolean newIsActive,
                           boolean newAllowRate,
                           boolean newAllowRateIcons,
                           Date newModified) {

        categoryValidator.validate(newImgId,
                newLabel,
                newDescription,
                newIsActive,
                newAllowRate,
                newAllowRateIcons,
                newModified);
        Category category = get(id);
        category.setImgId(newImgId);
        category.setLabel(newLabel);
        category.setDescription(newDescription);
        category.setIsActive(newIsActive);
        category.setAllowRate(newAllowRate);
        category.setAllowRateIcons(newAllowRateIcons);
        category.setModifed(newModified);
        return category;
    }

    @Override
    public Category get(Long id) {
        return categoryDAO.getRequired(id);
    }
}
