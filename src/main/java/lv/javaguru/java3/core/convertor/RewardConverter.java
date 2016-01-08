package lv.javaguru.java3.core.convertor;

import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;
import lv.javaguru.java3.core.dto.gallerycluster.RewardDTO;

import static lv.javaguru.java3.core.domain.gallerycluster.reward.RewardBuilder.aReward;
import static lv.javaguru.java3.core.dto.gallerycluster.RewardDTOBuilder.aRewardDTO;

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

    /*public Reward copyData(Reward reward, RewardDTO rewardDTO){
        if (rewardDTO == null) return reward;
        reward.setName(rewardDTO.getName());
        reward.setDescription(rewardDTO.getDescription());
        reward.setIsActive(rewardDTO.isActive());
        reward.setLabel(rewardDTO.getLabel());
        return reward;
    }*/
  /*  public <T>T copyData(T orig, E data){
        if (data == null) return orig;
        reward.setName(rewardDTO.getName());
        reward.setDescription(rewardDTO.getDescription());
        reward.setIsActive(rewardDTO.isActive());
        reward.setLabel(rewardDTO.getLabel());
        return null;
    }*/
    public Reward copyData(Reward reward, RewardDTO rewardDTO){
        if (rewardDTO == null) return null;
        if (rewardDTO.getName() != null)
            reward.setName(rewardDTO.getName());
        if (rewardDTO.getDescription() != null)
            reward.setDescription(rewardDTO.getDescription());
        if (rewardDTO.isActive())
            reward.setIsActive(rewardDTO.isActive());
        if (rewardDTO.getLabel() != null)
            reward.setLabel(rewardDTO.getLabel());
        return reward;

    }
    public RewardDTO copyData(Reward reward){
        if (reward == null) return null;
        return aRewardDTO()
                .withId(reward.getId())
                .withDescription(reward.getDescription())
                .withIsActive(reward.isActive())
                .withLabel(reward.getLabel())
                .withName(reward.getName())
                .build();
    }

}
