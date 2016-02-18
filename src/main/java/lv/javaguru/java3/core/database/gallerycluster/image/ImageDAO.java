package lv.javaguru.java3.core.database.gallerycluster.image;

import lv.javaguru.java3.core.database.CRUDOperationDAO;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;
import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;

import java.util.List;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public interface ImageDAO extends CRUDOperationDAO<Image, Long> {
    List<Image> loadImagesPaged(Long categoryId, int page, int size);
    List<Image> loadImagesPaged(Long categoryId, int page);

    List<Reward> loadImagesRewards(Long imageId);
    Long imageCount(Long categoryId);

}
