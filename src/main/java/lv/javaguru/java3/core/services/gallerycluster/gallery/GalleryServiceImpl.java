package lv.javaguru.java3.core.services.gallerycluster.gallery;

import lv.javaguru.java3.core.convertor.GalleryConverter;
import lv.javaguru.java3.core.database.gallerycluster.category.CategoryDAO;
import lv.javaguru.java3.core.database.gallerycluster.gallery.GalleryDAO;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryPageDTO;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;
import lv.javaguru.java3.core.dto.gallerycluster.PageDTO;
import static lv.javaguru.java3.core.dto.gallerycluster.PageDTOBuilder.aPageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired private GalleryValidator galleryValidator;
    @Autowired private GalleryDAO galleryDAO;
    @Autowired private CategoryDAO categoryDAO;
    @Autowired private GalleryConverter galleryConverter;

    @Override
    @Deprecated
    public Gallery update(long galleryId,
                          String newLabel,
                          String newDescription,
                          boolean newIsActive,
                          boolean newAllowRate,
                          boolean newAllowRateIcons) {
           galleryValidator.validate(newLabel,
                   newDescription,
                   newIsActive,
                   newAllowRate,
                   newAllowRateIcons);
/*
        Gallery gallery = get(galleryId);
        gallery.setLabel(newLabel);
        gallery.setDescription(newDescription);
        gallery.setIsActive(newIsActive);
        gallery.setAllowRate(newAllowRate);
        gallery.setAllowRateIcons(newAllowRateIcons);*/
        return null;
    }

    @Override
    public GalleryDTO get(Long id) {
        Gallery gallery = galleryDAO.getRequired(id);
               // gallery.setCategories(null);
        GalleryDTO galleryDTO = galleryConverter.convert(gallery);
                 //  galleryDTO.setCategoryDTOs(null);
                 //  galleryDTO.setAddition(null);
        return  galleryDTO;
    }

    @Override
    @Deprecated
    public List<Gallery> getAll() {
        List<Gallery>  galleries = galleryDAO.getAll();
       // galleries
        return  galleryDAO.getAll();
    }


    @Override
    public GalleryDTO updateDTO(GalleryDTO galleryDTO) {
        galleryValidator.validate(galleryDTO);
        galleryDAO.update(galleryConverter.convert(galleryDTO));
        return galleryDTO;
    }
    @Override
    public Gallery update(GalleryDTO galleryDTO) {
        galleryValidator.validate(galleryDTO);
        Gallery gallery = galleryConverter.convert(galleryDTO);
        galleryDAO.update(gallery);
        return gallery;
    }

    @Override
    public void delete(long id) {
        Gallery gallery = galleryDAO.getRequired(id);
        galleryDAO.delete(gallery);
    }

    @Override
    public Gallery update(Gallery gallery) {
        galleryValidator.validate(galleryConverter.convert(gallery));
        galleryDAO.update(gallery);
        return gallery;
    }

    @Override
    public GalleryDTO getWithPagingList(Long id, int page, int size) {

        Gallery gallery = galleryDAO.getRequired(id);
              //  gallery.setCategories(null);

        GalleryDTO galleryDTO = galleryConverter.convert(gallery);
                 //  galleryDTO.setCategoryDTOs(null);
                   galleryDTO.setAddition(
                           buildPage(id, page, size)
                   );
        return  galleryDTO;
    }

    private PageDTO buildPage(Long id, int page, int size){
        List<CategoryPageDTO> pages = categoryDAO.findAllWithPaginationAndThumbs(id, page, size);
        int pageCount = calculatePageCount(categoryDAO.categoryCount(id), size);
        return  aPageDTO()
                .withPage((long)page)
                .withPageCount((long)pageCount)
                .withPagedEntity(pages)
                .build();
    }

    private int calculatePageCount(long items, int size){
       return (int)Math.ceil((double)items/size);
    }
}
