package lv.javaguru.java3.core.services.gallerycluster.category;

import lv.javaguru.java3.core.convertor.CategoryConverter;
import lv.javaguru.java3.core.database.gallerycluster.category.CategoryDAO;
import lv.javaguru.java3.core.database.gallerycluster.image.ImageDAO;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryDTO;
import lv.javaguru.java3.core.dto.gallerycluster.ImageDTO;
import lv.javaguru.java3.core.dto.gallerycluster.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

import static lv.javaguru.java3.core.dto.gallerycluster.PageDTOBuilder.aPageDTO;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired private CategoryValidator categoryValidator;
    @Autowired private CategoryDAO categoryDAO;
    @Autowired private ImageDAO imageDAO;
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
    public CategoryDTO updateDTO(CategoryDTO categoryDTO) {
        categoryValidator.validate(categoryDTO);
        categoryDAO.update(categoryConverter.convert(categoryDTO));
        return categoryDTO;
    }
    @Override
    public Category update(CategoryDTO categoryDTO) {
        categoryValidator.validate(categoryDTO);
        Category category = categoryConverter.convert(categoryDTO);
        categoryDAO.update(category);
        return category;
    }

    @Override
    public void delete(long id) {
        Category category = categoryDAO.getRequired(id);
        categoryDAO.delete(category);

    }

    @Override
    public CategoryDTO getCategoryImagesLimited(Long id, int page, int size) {
         Category category = get(id);
        List<Image> images = imageDAO.loadImagesPaged(id,page,size);
                  category.setImages(images);
         CategoryDTO categoryDTO = categoryConverter.convert(category);
                     categoryDTO.setAddition(
                             buildPage(id,page,size)
                     );

        return categoryDTO;
    }

    @Override
    public CategoryDTO getCategoryImagesSmall(Long id, int page) {
        Category category = get(id);
        List<Image> images = imageDAO.loadImagesPaged(id,page);
                category.setImages(images);
        Long pageCount = imageDAO.imageCount(id);
        CategoryDTO categoryDTO = categoryConverter.convert(category);
            categoryDTO.setAddition(
                    aPageDTO()
                            .withPage((long)page)
                            .withPageCount(pageCount)
                            .build()
             );
        return categoryDTO;
    }

    private PageDTO buildPage(Long id, int page, int size){
        int pageCount = calculatePageCount(imageDAO.imageCount(id), size);
        return  aPageDTO()
                .withPage((long)page)
                .withPageCount((long)pageCount)
                .build();
    }

    private int calculatePageCount(long items, int size){
        return (int)Math.ceil((double)items/size);
    }
}
