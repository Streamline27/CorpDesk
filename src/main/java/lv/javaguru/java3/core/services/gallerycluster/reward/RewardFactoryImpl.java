package lv.javaguru.java3.core.services.gallerycluster.reward;

import lv.javaguru.java3.core.convertor.RewardConverter;
import lv.javaguru.java3.core.database.gallerycluster.reward.RewardDAO;
import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;
import static lv.javaguru.java3.core.domain.gallerycluster.reward.RewardBuilder.aReward;

import lv.javaguru.java3.core.dto.gallerycluster.RewardDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class RewardFactoryImpl implements RewardFactory{

    @Autowired private RewardValidator rewardValidator;
    @Autowired private RewardDAO rewardDAO;
    @Autowired private RewardConverter rewardConverter;

    @Override
    public Reward create(String name,
                         String label,
                         String description,
                         boolean isActive) {
     /*   galleryValidator.validate(label,
                description,
                isActive,
                allowRate,
                allowRateIcons
        );*/

        Reward reward = aReward()
                .withName(name)
                .withLabel(label)
                .withDescription(description)
                .withIsActive(isActive)
                .build();
        rewardDAO.create(reward);
        return reward;
    }

    @Override
    public RewardDTO createDTO(RewardDTO rewardDTO) {
        rewardValidator.validate(rewardDTO);
        rewardDAO.create(rewardConverter.convert(rewardDTO));
        return rewardDTO;
    }
    @Override
    public Reward create(RewardDTO rewardDTO) {
        rewardValidator.validate(rewardDTO);
        Reward reward = rewardConverter.convert(rewardDTO);
        rewardDAO.create(reward);
        return reward;
    }
}
