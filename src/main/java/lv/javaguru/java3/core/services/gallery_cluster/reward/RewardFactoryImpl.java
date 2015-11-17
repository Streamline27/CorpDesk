package lv.javaguru.java3.core.services.gallery_cluster.reward;

import lv.javaguru.java3.core.commands.gallery_cluster.converter.RewardConverter;
import lv.javaguru.java3.core.database.gallery_cluster.reward.RewardDAO;
import lv.javaguru.java3.core.domain.gallery_cluster.reward.Reward;
import static lv.javaguru.java3.core.domain.gallery_cluster.reward.RewardBuilder.aReward;

import lv.javaguru.java3.core.dto.gallery_cluster.RewardDTO;
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
    public RewardDTO create(RewardDTO rewardDTO) {
        rewardValidator.validate(rewardDTO);
        rewardDAO.create(rewardConverter.convert(rewardDTO));
        return rewardDTO;
    }
}
