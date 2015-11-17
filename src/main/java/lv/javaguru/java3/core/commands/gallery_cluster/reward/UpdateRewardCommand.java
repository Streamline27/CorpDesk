package lv.javaguru.java3.core.commands.gallery_cluster.reward;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.dto.gallery_cluster.RewardDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateRewardCommand implements DomainCommand<UpdateRewardResult> {
    private final RewardDTO rewardDTO;

    public UpdateRewardCommand(RewardDTO rewardDTO){
        this.rewardDTO = rewardDTO;
    }

    public RewardDTO getRewardDTO(){
        return rewardDTO;
    }
}
