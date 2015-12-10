package lv.javaguru.java3.core.commands.gallerycluster.handler.reward;

import lv.javaguru.java3.core.commands.gallerycluster.converter.RewardConverter;
import lv.javaguru.java3.core.commands.gallerycluster.reward.GetRewardCommand;
import lv.javaguru.java3.core.commands.gallerycluster.reward.GetRewardResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.reward.RewardService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GetRewardCommandHandler
        implements DomainCommandHandler<GetRewardCommand, GetRewardResult> {


    @Autowired private RewardService rewardService;
    @Autowired private RewardConverter rewardConverter;

    @Override
    public GetRewardResult execute(GetRewardCommand command) throws Exception {
        return new GetRewardResult(rewardConverter.convert(rewardService.get(command.getRewardId())));
    }

    @Override
    public Class getCommandType() {
        return GetRewardCommand.class;
    }
}
