package lv.javaguru.java3.core.services.gallery_cluster.reward;

import lv.javaguru.java3.core.database.gallery_cluster.reward.RewardDAO;
import lv.javaguru.java3.core.domain.gallery_cluster.reward.Reward;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class RewardServiceImpl implements RewardService{

    @Autowired private RewardValidator rewardValidator;
    @Autowired private RewardDAO rewardDAO;

    @Override
    public Reward update(Long id,
                         String newName,
                         String newLabel,
                         String newDescription,
                         boolean newIsActive) {
      /*  galleryValidator.validate(newLabel,
                newDescription,
                newIsActive,
                newAllowRate,
                newAllowRateIcons);*/


        Reward reward = get(id);
        reward.setName(newName);
        reward.setLabel(newLabel);
        reward.setDescription(newDescription);
        reward.setIsActive(newIsActive);
        return reward;
    }

    @Override
    public Reward get(Long id) {
            return rewardDAO.getRequired(id);
    }
}
