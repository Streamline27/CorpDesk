package lv.javaguru.java3.core.database.gallerycluster.reward;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;
import static lv.javaguru.java3.core.domain.gallerycluster.reward.RewardBuilder.aReward;


import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.*;

import static lv.javaguru.java3.core.domain.gallerycluster.image.ImageBuilder.anImage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static lv.javaguru.java3.core.domain.gallerycluster.category.CategoryBuilder.aCategory;
import static lv.javaguru.java3.core.domain.gallerycluster.gallery.GalleryBuilder.aGallery;
import static org.junit.Assert.*;

/**
 * Created by Aleksej_home on 2015.12.02..
 */
public class RewardDAOImplTest extends DatabaseHibernateTest {


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
    public void testCreateReward() {
        try {
            startTransaction();
        rewardDAO.create(reward);
        assertTrue(reward.getId() > 0);

        Reward rewardFromDb = rewardDAO.getById(reward.getId());
        assertThat(rewardFromDb, is(notNullValue()));
        rewardDAO.delete(reward);

        rewardFromDb = rewardDAO.getById(rewardFromDb.getId());
        assertEquals(null, rewardFromDb);
            commitTransaction();
        }catch (RuntimeException e) {
            e.printStackTrace();
        }

    }


    @Test
    @Transactional
    public void testCreateMultipleRewards() {
        try {
            startTransaction();
            List<Reward> rewards = rewardDAO.getAll();
            int rewardsCount = rewards == null ? 0 : rewards.size();

            reward.setImages(null);
            reward2.setImages(null);

            rewardDAO.create(reward);
            rewardDAO.create(reward2);

            rewards = rewardDAO.getAll();
            assertEquals(2, rewards.size() - rewardsCount);

            rewardDAO.delete(reward);
            rewardDAO.delete(reward2);

            rewards = rewardDAO.getAll();
            assertEquals(0, rewards.size() - rewardsCount);
            commitTransaction();
        }catch (RuntimeException e) {
                e.printStackTrace();
            }

    }

    @Test
    @Transactional
    public void testUpdateReward() {
        try {
            startTransaction();

            rewardDAO.create(reward);

            reward = rewardDAO.getById(reward.getId());

            reward.setName(reward2.getName());
            reward.setDescription(reward2.getDescription());
            reward.setIsActive(reward2.isActive());
            reward.setLabel(reward2.getLabel());

            rewardDAO.update(reward);

            Reward rewardFromDb = rewardDAO.getById(reward.getId());
            assertNotNull(rewardFromDb);
            assertEquals(reward2.getName(), rewardFromDb.getName());
            assertEquals(reward2.getDescription(), rewardFromDb.getDescription());
            assertEquals(reward2.getLabel(), rewardFromDb.getLabel());
            assertEquals(reward2.isActive(), rewardFromDb.isActive());

            rewardDAO.delete(reward);

            rewardFromDb = rewardDAO.getById(rewardFromDb.getId());
            assertEquals(null, rewardFromDb);

            commitTransaction();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }


    }


    @Test
    @Transactional
    public void testCreateRewardWithImages() {
        try {
            startTransaction();
            List<Reward> rewards2 = new ArrayList<>();


            List<Image> images1 = new ArrayList<>();
            List<Reward> rewards1 = new ArrayList<>();

            images1.add(image);
            images1.add(image2);

            rewards1.add(reward);
            rewards1.add(reward2);

            image.setRewards(rewards1);
            reward.setImages(images1);


            rewardDAO.create(reward);

            Reward rewardFromDb = rewardDAO.getById(reward.getId());
            assertThat(rewardFromDb, is(notNullValue()));

            assertEquals(rewardFromDb.getImages().size(), reward.getImages().size());

            rewardDAO.delete(reward);

            rewardFromDb = rewardDAO.getById(rewardFromDb.getId());

            assertEquals(null, rewardFromDb);

            commitTransaction();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }


    }


}
