package lv.javaguru.java3.core.database.gallerycluster.reward;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;
import static lv.javaguru.java3.core.domain.gallerycluster.reward.RewardBuilder.aReward;

import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;

import javax.management.Query;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.*;

import static lv.javaguru.java3.core.domain.gallerycluster.image.ImageBuilder.anImage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static lv.javaguru.java3.core.domain.gallerycluster.category.CategoryBuilder.aCategory;
import static lv.javaguru.java3.core.domain.gallerycluster.gallery.GalleryBuilder.aGallery;

/**
 * Created by Aleksej_home on 2015.12.02..
 */
public class RewardDAOImplTest extends DatabaseHibernateTest {

    private Category category;
    private Gallery gallery;
    private Image image, image2;
    private Reward reward, reward2;

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
     /*   rewardDAO.create(reward);
        assertTrue(reward.getId() > 0);

        Reward rewardFromDb = rewardDAO.getById(reward.getId());
        assertThat(rewardFromDb, is(notNullValue()));*/

    }


    @Test
    @Transactional
    public void testCreateMultipleRewards() {

    /*    galleryDAO.create(gallery);
        category.setGallery(gallery);
        categoryDAO.create(category);
        image.setCategory(category);

        List<Image> images = imageDAO.getAll();
        int imagesCount = images == null ? 0 : images.size();

        imageDAO.create(image);
        image2.setCategory(category);
        imageDAO.create(image2);
        images = Arrays.asList(image, image2);

        List<Reward> rewards = rewardDAO.getAll();
        int rewardsCount = rewards == null ? 0 : rewards.size();

        reward.setImages(images);
        rewardDAO.create(reward);
        reward2.setImages(images);
        rewardDAO.create(reward2);

        assertTrue(reward.getId() > 0);
        assertTrue(reward2.getId() > 0);
        rewards = rewardDAO.getAll();
        assertEquals(2, rewards.size() - rewardsCount);*/
      /*  List<Image> images1 = new ArrayList<>();
        List<Reward> rewards1 = new ArrayList<>();
        List<Reward> rewards2 = new ArrayList<>();

        images1.add(image);
        rewards1.add(reward);

        image.setRewards(rewards1);
        reward.setImages(images1);

        rewardDAO.create(reward);

        rewards2 = rewardDAO.getAll();*/
        List<Reward> rewards2 = new ArrayList<>();

    /*    reward.addImage(image);
      //  reward.addImage(image2);

        reward2.addImage(image);

        image.addReward(reward);
        image2.addReward(reward);
        image.addReward(reward2);*/
        List<Image> images1 = new ArrayList<>();
        List<Reward> rewards1 = new ArrayList<>();

        images1.add(image);
        images1.add(image2);

        rewards1.add(reward);
        rewards1.add(reward2);

        image.setRewards(rewards1);
        reward.setImages(images1);


       // rewardDAO.create(reward);
      //  rewardDAO.create(reward2);
       // sessionFactory.getCurrentSession().save(reward);
        System.out.println("***************************************************************************\n");
        System.out.println("%%%%%%: "+reward.getId()+ "\n");
        System.out.println("***************************************************************************\n");
      //  try {
       // sessionFactory.getCurrentSession().flush();
            sessionFactory.getCurrentSession().save(reward);
            System.out.println("DDDDDDDD: " + reward.getId() + "\n");
            //reward.setId(4l);
           // sessionFactory.getCurrentSession().save(reward);
          //  sessionFactory.getCurrentSession().flush();
           // sessionFactory.getCurrentSession().delete(reward);
            sessionFactory.getCurrentSession().flush();
           // org.hibernate.Query q = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM rewards where id = 2");
           // q.executeUpdate();
      /*  }catch (HibernateException e) {
            e.printStackTrace();
            sessionFactory.getCurrentSession().getTransaction().rollback();
        }*/
       /* System.out.println("***************************************************************************\n");
        System.out.println("***************************************************************************\n");
        System.out.println("***************************************************************************\n");*/

      //  rewards2 = rewardDAO.getAll();

    /*    System.out.println("***************************************************************************\n");
        System.out.println(">>>>I: "+ rewards2.get(0).getImages().size()+ "\n");
        System.out.println(">>>>R: "+ rewards2.size()+ "\n");

        for (Reward re : rewards2){
            System.out.println(">>>>OP: "+ re.getImages().size() + "\n");
        }

        System.out.println("----------------------------------------------------------------------------------\n");
        System.out.println(">>>>SZ: "+ rewards2.get(rewards2.size() - 1).getImages().size()+ "\n");
        System.out.println(">>>>Var1: "+  rewards2.get(rewards2.size() - 1).getImages().get(0).getId()+ "\n");
        System.out.println(">>>>Var1: "+  rewards2.get(rewards2.size() - 1).getImages().get(0).getLabel()+ "\n");
        System.out.println(">>>>ZZ: "+  rewards2.get(rewards2.size() - 1).getImages().get(1).getId()+ "\n");
        System.out.println(">>>>Zz: "+  rewards2.get(rewards2.size() - 1).getImages().get(1).getLabel()+ "\n");

        System.out.println("***************************************************************************\n");
*/
      /*  System.out.println("***************************************************************************\n");
        for (Reward re : rewards2){
            System.out.println(">>>>: "+ re.getImages().size() + "\n");
            System.out.println("******************************");
        }
        System.out.println("***************************************************************************\n");
*/
    }

}
