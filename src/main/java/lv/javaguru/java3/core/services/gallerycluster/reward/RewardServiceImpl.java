package lv.javaguru.java3.core.services.gallerycluster.reward;

import lv.javaguru.java3.core.commands.gallerycluster.converter.RewardConverter;
import lv.javaguru.java3.core.database.gallerycluster.reward.RewardDAO;
import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;
import lv.javaguru.java3.core.dto.gallerycluster.RewardDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class RewardServiceImpl implements RewardService{

    @Autowired private RewardValidator rewardValidator;
    @Autowired private RewardDAO rewardDAO;
    @Autowired private RewardConverter rewardConverter;

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

    @Override
    public Reward update(Reward reward) {
        rewardValidator.validate(rewardConverter.convert(reward));
        rewardDAO.update(reward);
        return reward;
    }

    @Override
    public RewardDTO update(RewardDTO rewardDTO) {
        rewardValidator.validate(rewardDTO);
        rewardDAO.update(rewardConverter.convert(rewardDTO));
        return rewardDTO;
    }

    @Override
    public void delete(long id) {
        Reward reward = rewardDAO.getRequired(id);
        rewardDAO.delete(reward);
    }
}
