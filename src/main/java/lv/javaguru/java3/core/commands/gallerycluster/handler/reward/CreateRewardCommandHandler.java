package lv.javaguru.java3.core.commands.gallerycluster.handler.reward;

import lv.javaguru.java3.core.commands.gallerycluster.reward.CreateRewardCommand;
import lv.javaguru.java3.core.commands.gallerycluster.reward.CreateRewardResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.reward.RewardFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateRewardCommandHandler
        implements DomainCommandHandler<CreateRewardCommand, CreateRewardResult> {


    @Autowired private RewardFactory rewardFactory;

    @Override
    public CreateRewardResult execute(CreateRewardCommand command) throws Exception {
        return new CreateRewardResult(rewardFactory.create(command.getRewardDTO()));
    }

    @Override
    public Class getCommandType() {
        return CreateRewardCommand.class;
    }
}
