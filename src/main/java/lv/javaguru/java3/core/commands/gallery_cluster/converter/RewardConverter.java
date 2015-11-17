package lv.javaguru.java3.core.commands.gallery_cluster.converter;

import lv.javaguru.java3.core.domain.gallery_cluster.reward.Reward;
import lv.javaguru.java3.core.dto.gallery_cluster.RewardDTO;

import static lv.javaguru.java3.core.domain.gallery_cluster.reward.RewardBuilder.aReward;
import static lv.javaguru.java3.core.dto.gallery_cluster.RewardDTOBuilder.aRewardDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class RewardConverter {

    public RewardDTO convert(Reward reward){
        if (reward == null) return null;
        return aRewardDTO()
                .withId(reward.getId())
                .withDescription(reward.getDescription())
                .withIsActive(reward.isActive())
                .withLabel(reward.getLabel())
                .withName(reward.getName())
                .build();
    }
    public Reward convert(RewardDTO rewardDTO){
        if (rewardDTO == null) return null;
        return aReward()
                .withId(rewardDTO.getId())
                .withDescription(rewardDTO.getDescription())
                .withIsActive(rewardDTO.isActive())
                .withLabel(rewardDTO.getLabel())
                .withName(rewardDTO.getName())
                .build();
    }

}
