package lv.javaguru.java3.core.commands.gallerycluster.reward;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.dto.gallerycluster.RewardDTO;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateRewardCommand implements DomainCommand<CreateRewardResult> {
  private final RewardDTO rewardDTO;

    public CreateRewardCommand(RewardDTO rewardDTO){
        this.rewardDTO = rewardDTO;
    }

    public RewardDTO getRewardDTO(){
        return rewardDTO;
    }
}
