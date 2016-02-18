package lv.javaguru.java3.core.database.gallerycluster.image;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
@Component
public class ImageDAOImpl extends CRUDOperationDAOImpl<Image, Long> implements ImageDAO {
    @Override
    public List<Image> loadImagesPaged(Long categoryId, int page, int size) {
        return  (List)getCurrentSession()
                .createCriteria(Image.class)
                .setFirstResult((page - 1) * size).setMaxResults(size)
                .add(Restrictions.eq("categoryId", categoryId))
                .list();
    }

    @Override
    public Long imageCount(Long categoryId) {
        return (Long)getCurrentSession()
                .createCriteria(Image.class)
                .add(Restrictions.eq("categoryId", categoryId))
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    @Override
    public List<Image> loadImagesPaged(Long categoryId, int page) {
        return  (List)getCurrentSession()
                .createCriteria(Image.class)
                .setFirstResult(page - 1).setMaxResults(1)
                .add(Restrictions.eq("categoryId", categoryId))
                .list();
    }

    @Override
    public List<Reward> loadImagesRewards(Long imageId) {
       /* return  (List)getCurrentSession()
                .createCriteria(Reward.class)
                .setFirstResult(page - 1).setMaxResults(1)
                .add(Restrictions.eq("categoryId", categoryId))
                .add(Restrictions.eq("categoryId", categoryId))
                .list();*/
        return null;
    }
}
