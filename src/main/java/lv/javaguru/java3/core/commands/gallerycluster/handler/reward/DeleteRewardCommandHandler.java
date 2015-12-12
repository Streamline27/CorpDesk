package lv.javaguru.java3.core.commands.gallerycluster.handler.reward;

import lv.javaguru.java3.core.commands.gallerycluster.reward.DeleteRewardCommand;
import lv.javaguru.java3.core.commands.gallerycluster.reward.DeleteRewardResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.reward.RewardService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class DeleteRewardCommandHandler
        implements DomainCommandHandler<DeleteRewardCommand, DeleteRewardResult> {


    @Autowired private RewardService rewardService;

    @Override
    public DeleteRewardResult execute(DeleteRewardCommand command) throws Exception {
        rewardService.delete(command.getRewardId());
        return new DeleteRewardResult();
    }

    @Override
    public Class getCommandType() {
        return DeleteRewardCommand.class;
    }
}
