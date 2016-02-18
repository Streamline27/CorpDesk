package lv.javaguru.java3.core.database.gallerycluster.category;

import lv.javaguru.java3.core.database.CRUDOperationDAOImpl;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryPageDTO;
import lv.javaguru.java3.helpers.AliasToBeanNestedResultTransformer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
@Component
public class CategoryDAOImpl  extends CRUDOperationDAOImpl<Category, Long> implements CategoryDAO {

 //   @Autowired
   // AliasToBeanNestedResultTransformer aliasToBeanNestedResultTransformer;

    @Override
    public List<CategoryPageDTO> findAllWithPaginationAndThumbs(Long galleryId, int page, int size) {
        Criteria criteria = getCurrentSession()
                .createCriteria(Category.class, "category")
                .add(Restrictions.eq("category.galleryId", galleryId))
                .setFirstResult((page - 1) * size).setMaxResults(size)
                .createAlias("category.images", "images", JoinType.LEFT_OUTER_JOIN)
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("images.categoryId"))
                        .add(Projections.groupProperty("category.id").as("id"))
                        .add(Projections.count("images.id").as("imgCount"))
                        .add(Projections.property("category.label").as("label"))
                        .add(Projections.property("category.description").as("description"))
                        .add(Projections.property("category.isActive").as("isActive"))
                        .add(Projections.property("category.allowRate").as("allowRate"))
                        .add(Projections.property("category.allowRateIcons").as("allowRateIcons"))
                        .add(Projections.property("images.id").as("imageId"))
                        .add(Projections.property("images.description").as("imageDescription"))
                        .add(Projections.property("images.isActive").as("imageIsActive"))
                        .add(Projections.property("images.label").as("imageLabel"))
                        .add(Projections.property("images.thumb").as("imageThumb")))
                    .addOrder(Order.desc("category.id"))
                    .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                    .setResultTransformer(Transformers.aliasToBean(CategoryPageDTO.class));
      //  .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

        return criteria.list();
    }

    @Override
    public Long categoryCount(Long galleryId) {
        return (Long)getCurrentSession()
                .createCriteria(Category.class)
                .add(Restrictions.eq("galleryId", galleryId))
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }


}
