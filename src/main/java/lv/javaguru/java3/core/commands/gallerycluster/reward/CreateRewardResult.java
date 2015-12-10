package lv.javaguru.java3.core.commands.gallerycluster.reward;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.gallerycluster.RewardDTO;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateRewardResult implements DomainCommandResult{
    private final RewardDTO rewardDTO;

    public CreateRewardResult(RewardDTO rewardDTO){
        this.rewardDTO = rewardDTO;
    }

    public RewardDTO getRewardDTO(){
        return rewardDTO;
    }
}
