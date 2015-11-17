package lv.javaguru.java3.core.commands.gallery_cluster.reward;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.gallery_cluster.RewardDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateRewardResult implements DomainCommandResult {
    private final RewardDTO rewardDTO;

    public UpdateRewardResult(RewardDTO rewardDTO){
        this.rewardDTO = rewardDTO;
    }

    public RewardDTO getRewardDTO(){
        return rewardDTO;
    }
}
