package lv.javaguru.java3.core.database.gallerycluster.image;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import static lv.javaguru.java3.core.domain.gallerycluster.image.ImageBuilder.anImage;

import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lv.javaguru.java3.core.domain.gallerycluster.category.CategoryBuilder.aCategory;
import static lv.javaguru.java3.core.domain.gallerycluster.gallery.GalleryBuilder.aGallery;
import static lv.javaguru.java3.core.domain.gallerycluster.reward.RewardBuilder.aReward;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Aleksej_home on 2015.12.02..
 */
public class ImageDAOImplTest extends DatabaseHibernateTest {

    private Image image, image2;
    private Reward reward, reward2;


    @Before
    public void init()  {


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
        reward = aReward()
                .withDescription("Vata for sh")
                .withIsActive(true)
                .withLabel("vata.jpg")
                .withName("Vata")

                .build();
        reward2 = aReward()
                .withDescription("Brutal person")
                .withIsActive(true)
                .withLabel("brutal.jpg")
                .withName("Brutal")
                .build();



    }

    @Test
    @Transactional
    public void testCreateImage() {
        try {
            startTransaction();
            imageDAO.create(image);
            assertTrue(image.getId() > 0);

            Image imageFromDb = imageDAO.getById(image.getId());
            assertThat(imageFromDb, is(notNullValue()));
            imageDAO.delete(image);

            imageFromDb = imageDAO.getById(imageFromDb.getId());
            assertEquals(null, imageFromDb);
            commitTransaction();
        }catch (RuntimeException e) {
            e.printStackTrace();
        }

    }


    @Test
    @Transactional
    public void testCreateMultipleImages() {
        try {
            startTransaction();
            List<Image> images = imageDAO.getAll();
            int imagesCount = images == null ? 0 : images.size();


            imageDAO.create(image);
            imageDAO.create(image2);

            images = imageDAO.getAll();
            assertEquals(2, images.size() - imagesCount);

            imageDAO.delete(image);
            imageDAO.delete(image2);

            images = imageDAO.getAll();
            assertEquals(0, images.size() - imagesCount);
            commitTransaction();
        }catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

    @Test
    @Transactional
    public void testUpdateImage() {
        try {
            startTransaction();

            imageDAO.create(image);

            image = imageDAO.getById(image.getId());

            image.setAllowRate(image2.getAllowRate());
            image.setAllowRateIcons(image2.getAllowRateIcons());
            image.setMiddle(image2.getMiddle());
            image.setModifed(new Date(System.currentTimeMillis()));
            image.setOrig(image2.getOrig());
            image.setRate(image2.getRate());
            image.setThumb(image2.getThumb());
            image.setDescription(image2.getDescription());
            image.setIsActive(image2.isActive());
            image.setLabel(image2.getLabel());

            imageDAO.update(image);

            Image imageFromDb = imageDAO.getById(image.getId());
            assertNotNull(imageFromDb);
            assertEquals(image2.getDescription(), imageFromDb.getDescription());
            assertEquals(image2.getLabel(), imageFromDb.getLabel());
            assertEquals(image2.isActive(), imageFromDb.isActive());
            assertEquals(image2.getMiddle(), imageFromDb.getMiddle());
            assertEquals(image2.getOrig(), imageFromDb.getOrig());
            assertEquals(image2.getAllowRate(), imageFromDb.getAllowRate());
            assertEquals(image2.getAllowRateIcons(), imageFromDb.getAllowRateIcons());
            assertEquals(image2.getRate(), imageFromDb.getRate());

            imageDAO.delete(image);

            imageFromDb = imageDAO.getById(imageFromDb.getId());
            assertEquals(null, imageFromDb);

            commitTransaction();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }


    }


    @Test
    @Transactional
    public void testCreateimageWithImages() {
        try {
            startTransaction();
            List<Image> images2 = new ArrayList<>();


            List<Reward> rewards1 = new ArrayList<>();
            List<Image> images1 = new ArrayList<>();

            images1.add(image);
            images1.add(image2);

            rewards1.add(reward);
            rewards1.add(reward2);

            image.setRewards(rewards1);
            reward.setImages(images1);



            imageDAO.create(image);

            Image imageFromDb = imageDAO.getById(image.getId());
            assertThat(imageFromDb, is(notNullValue()));

            assertEquals(imageFromDb.getRewards().size(), image.getRewards().size());

            imageDAO.delete(image);

            imageFromDb = imageDAO.getById(imageFromDb.getId());

            assertEquals(null, imageFromDb);

            commitTransaction();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }


    }

}
