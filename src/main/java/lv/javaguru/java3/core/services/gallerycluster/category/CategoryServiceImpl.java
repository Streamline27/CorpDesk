package lv.javaguru.java3.core.services.gallerycluster.category;

import lv.javaguru.java3.core.commands.gallerycluster.converter.CategoryConverter;
import lv.javaguru.java3.core.database.gallerycluster.category.CategoryDAO;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class CategoryServiceImpl implements CategoryService {

    @Autowired private CategoryValidator categoryValidator;
    @Autowired private CategoryDAO categoryDAO;
    @Autowired private CategoryConverter categoryConverter;

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
      //  category.setImgId(newImgId);
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

    @Override
    public Category update(Category category) {
        categoryValidator.validate(categoryConverter.convert(category));
        categoryDAO.update(category);
        return category;
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        categoryValidator.validate(categoryDTO);
        categoryDAO.update(categoryConverter.convert(categoryDTO));
        return categoryDTO;
    }

    @Override
    public void delete(long id) {
        Category category = categoryDAO.getRequired(id);
        categoryDAO.delete(category);

    }
}
