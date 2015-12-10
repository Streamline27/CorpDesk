package lv.javaguru.java3.core.database.gallerycluster.image;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import static lv.javaguru.java3.core.domain.gallerycluster.image.ImageBuilder.anImage;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static lv.javaguru.java3.core.domain.gallerycluster.category.CategoryBuilder.aCategory;
import static lv.javaguru.java3.core.domain.gallerycluster.gallery.GalleryBuilder.aGallery;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Aleksej_home on 2015.12.02..
 */
public class ImageDAOImplTest extends DatabaseHibernateTest {
    private Category category;
    private Gallery gallery;
    private Image image, image2;


    @Before
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
              //  .withImgId(21l)
                .withIsActive(true)
                .withLabel("sans1")
                .withModified(new Date(System.currentTimeMillis()))
                .build();
        image = anImage()
                .withAllowRate(true)
                .withAllowRateIcons(true)
                .withDescription("some image desc1")
                .withIsActive(true)
                .withLabel("Image label1")
                .withMiddle("mid1")
                .withModified(new Date(System.currentTimeMillis()))
                .withOrig("orig1")
                .withRate(4)
                .withThumb("thm1")
                .build();
        image2 = anImage()
                .withAllowRate(false)
                .withAllowRateIcons(true)
                .withDescription("some image desc2")
                .withIsActive(true)
                .withLabel("Image label2")
                .withMiddle("mid2")
                .withModified(new Date(System.currentTimeMillis()))
                .withOrig("orig2")
                .withRate(2)
                .withThumb("thm2")
                .build();



    }
    @Test
    @Transactional
    public void testCreateImage() {

     //   List<Group> groups = Arrays.asList(group, group2);
     /*   galleryDAO.create(gallery);
        category.setGallery(gallery);
        categoryDAO.create(category);
        image.setCategory(category);
        imageDAO.create(image);*/
      //  imageDAO.create(image2);
       // categoryDAO.create(category);
     //   List<Image> images = Arrays.asList(image, image2);
      //  category.setImages(images);
      //  categoryDAO.create(category);


      //  assertTrue(image.getId() > 0);

      //  Image imageFromDB = imageDAO.getById(image.getId());
      //  assertThat(imageFromDB, is(notNullValue()));

    }

}
