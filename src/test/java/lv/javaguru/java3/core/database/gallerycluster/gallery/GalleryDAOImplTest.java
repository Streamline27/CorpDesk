package lv.javaguru.java3.core.database.gallerycluster.gallery;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;

import java.util.*;

import static lv.javaguru.java3.core.domain.gallerycluster.gallery.GalleryBuilder.aGallery;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/**
 * Created by Aleksej_home on 2015.11.24..
 */
public class GalleryDAOImplTest extends DatabaseHibernateTest{

    private Gallery gallery;
    private Gallery gallery2;
    private List<Gallery> stackVals2 = new ArrayList<>();
  //  private List<Object> stackVals2 = new ArrayList<>();
   // private long initialSize = 0;
   // private int key = 0;

    @Before
    public void init()  {

        gallery = aGallery()
                .withAllowRate(true)
                .withAllowRateIcons(true)
                .withDescription("derrrrr fdfdfdf gggggggg")
                .withIsActive(true)
                .withLabel("some sort of label1")
                .build();
       /* gallery2 = aGallery()
                .withAllowRate(true)
                .withAllowRateIcons(false)
                .withDescription("derrhhhhhhhhhhhhh gggg")
                .withIsActive(true)
                .withLabel("some sort of label2")
                .build();*/
        gallery2 = aGallery()
                .withAllowRate(true)
                .withAllowRateIcons(false)
                .withDescription("hhhhhhhhhhhhh gggg")
                .withIsActive(true)
                .withLabel("some sort of label2")
                .build();


    }


    @Test
    @Transactional
    public void testCreateGallery() {
        try {
            startTransaction();
        galleryDAO.create(gallery);
        assertThat(gallery, is(notNullValue()));

            Gallery galleryFromDb = galleryDAO.getById(gallery.getId());
            assertThat(galleryFromDb, is(notNullValue()));

            galleryDAO.delete(gallery);
            galleryFromDb = galleryDAO.getById(galleryFromDb.getId());
            assertEquals(null, galleryFromDb);
            commitTransaction();
        }catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    public void testGetGalleryById() {
        try {
            startTransaction();
        galleryDAO.create(gallery);
        Gallery galleryFromDB = galleryDAO.getById(gallery.getId());
        assertThat(galleryFromDB, is(notNullValue()));
        assertEquals(galleryFromDB.getId(), gallery.getId());
            galleryDAO.delete(gallery);
            galleryFromDB = galleryDAO.getById(galleryFromDB.getId());
            assertEquals(null, galleryFromDB);
            commitTransaction();
        }catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    public void testMultipleGalleryCreation()  {
        try {
            startTransaction();
        List<Gallery> galleries = galleryDAO.getAll();
        int galleriesCount = galleries == null ? 0 : galleries.size();

        galleryDAO.create(gallery);
        galleryDAO.create(gallery2);


        galleries = galleryDAO.getAll();
        assertEquals(2, galleries.size() - galleriesCount);

            galleryDAO.delete(gallery);
            galleryDAO.delete(gallery2);

            galleries = galleryDAO.getAll();
            assertEquals(0, galleries.size() - galleriesCount);


            commitTransaction();
        }catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    public void testUpdate()  {
        try {
            startTransaction();
        galleryDAO.create(gallery);

        gallery = galleryDAO.getById(gallery.getId());

        gallery.setAllowRate(gallery2.getAllowRate());
        gallery.setAllowRateIcons(gallery2.getAllowRateIcons());
        gallery.setDescription(gallery2.getDescription());
        gallery.setIsActive(gallery2.isActive());
        gallery.setLabel(gallery2.getLabel());

        galleryDAO.update(gallery);

        Gallery galleryFromDB = galleryDAO.getById(gallery.getId());

        assertNotNull(galleryFromDB);
        assertEquals(gallery2.getAllowRate(), galleryFromDB.getAllowRate());
        assertEquals(gallery2.getAllowRateIcons(), galleryFromDB.getAllowRateIcons());
        assertEquals(gallery2.isActive(), galleryFromDB.isActive());
        assertEquals(gallery2.getDescription(), galleryFromDB.getDescription());
        assertEquals(gallery2.getLabel(), galleryFromDB.getLabel());

         /*   galleryDAO.delete(gallery);
            galleryFromDB = galleryDAO.getById(galleryFromDB.getId());
            assertEquals(null, galleryFromDB);*/

            commitTransaction();
        }catch (RuntimeException e) {
            e.printStackTrace();
        }

    }




}
