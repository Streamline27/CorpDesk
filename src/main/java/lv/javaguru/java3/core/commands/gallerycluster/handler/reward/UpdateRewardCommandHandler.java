package lv.javaguru.java3.core.commands.gallerycluster.handler.reward;

import lv.javaguru.java3.core.commands.gallerycluster.reward.UpdateRewardCommand;
import lv.javaguru.java3.core.commands.gallerycluster.reward.UpdateRewardResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.reward.RewardService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateRewardCommandHandler
        implements DomainCommandHandler<UpdateRewardCommand, UpdateRewardResult> {


    @Autowired private RewardService rewardService;

    @Override
    public UpdateRewardResult execute(UpdateRewardCommand command) throws Exception {
        return new UpdateRewardResult(rewardService.update(command.getRewardDTO()));
    }

    @Override
    public Class getCommandType() {
        return UpdateRewardCommand.class;
    }
}
