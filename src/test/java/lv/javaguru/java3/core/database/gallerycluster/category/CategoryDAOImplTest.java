package lv.javaguru.java3.core.database.gallerycluster.category;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import static lv.javaguru.java3.core.domain.gallerycluster.category.CategoryBuilder.aCategory;

import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static lv.javaguru.java3.core.domain.gallerycluster.gallery.GalleryBuilder.aGallery;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class CategoryDAOImplTest extends DatabaseHibernateTest {

    private Category category;
    private Category category2;
    private Gallery gallery;


    @Before
  //  @Transactional
    public void init()  {

        gallery = aGallery()
                .withAllowRate(true)
                .withAllowRateIcons(true)
                .withDescription("derrrrr fdfdfdf categ")
                .withIsActive(true)
                .withLabel("some sort of label1")
                .build();
        category = aCategory()
                .withAllowRate(true)
                .withAllowRateIcons(true)
                .withDescription("Category 1 cfs")
                .withIsActive(true)
                .withLabel("sans1")
                .withModified(new Date(System.currentTimeMillis()))
                .build();
        category2 = aCategory()
                .withAllowRate(true)
                .withAllowRateIcons(false)
                .withDescription("Category 2 some")
                .withIsActive(true)
                .withLabel("sans1 dat")
                .withModified(new Date(System.currentTimeMillis()))
                .build();




    }
    @Test
    @Transactional
    public void testCreateCategory() {

    /*    galleryDAO.create(gallery);
        category.setGallery(gallery);
        categoryDAO.create(category);
        assertTrue(category.getId() > 0);

        Category categoryFromDB = categoryDAO.getById(category.getId());
        assertThat(categoryFromDB, is(notNullValue()));*/
    }

    @Test
    @Transactional
    public void testDelete(){
        //  List<Gallery> galleries = galleryDAO.getAll();
        // Gallery gallery = galleryDAO.getById(90l);
        // galleryDAO.delete(gallery);

    }



    @Test
    @Transactional
    public void testMultipleGalleryCreation()  {
/*
        galleryDAO.create(gallery);

        List<Category> categories = categoryDAO.getAll();
        int categoriesCount = categories == null ? 0 : categories.size();

        category.setGalleryId(gallery.getUserId());
        category2.setGalleryId(gallery.getUserId());

        categoryDAO.create(category);
        categoryDAO.create(category2);

        categories = categoryDAO.getAll();
        assertEquals(2, categories.size() - categoriesCount);
*/
    }

    @Test
    @Transactional
    public void testUpdateCategory()  {
      /*  galleryDAO.create(gallery);
        category.setGalleryId(gallery.getUserId());

        categoryDAO.create(category);
        category = categoryDAO.getById(category.getId());

        category.setAllowRate(category2.getAllowRate());
        category.setAllowRateIcons(category2.getAllowRateIcons());
        category.setImgId(category2.getImgId());
        category.setModifed(category2.getModifed());
        category.setDescription(category2.getDescription());
        category.setIsActive(category2.isActive());
        category.setLabel(category2.getLabel());

        categoryDAO.update(category);

        Category categoryFromDB = categoryDAO.getById(category.getId());

        assertNotNull(categoryFromDB);
        assertEquals(category2.getAllowRate(), categoryFromDB.getAllowRate());
        assertEquals(category2.getAllowRateIcons(), categoryFromDB.getAllowRateIcons());
        assertEquals(category2.isActive(), categoryFromDB.isActive());
        assertEquals(category2.getDescription(), categoryFromDB.getDescription());
        assertEquals(category2.getLabel(), categoryFromDB.getLabel());
        assertEquals(category2.getImgId(), categoryFromDB.getImgId());
        assertEquals(category2.getModifed(), categoryFromDB.getModifed());

*/
    }



}
