package lv.javaguru.java3.core.commands.gallery_cluster.handler.reward;

import lv.javaguru.java3.core.commands.gallery_cluster.reward.GetRewardCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.reward.GetRewardResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GetRewardCommandHandler
        implements DomainCommandHandler<GetRewardCommand, GetRewardResult> {

  /*  @Autowired CategoryService categoryService;
    @Autowired CategoryConverter categoryConverter;

    @Override
    public GetCategoryResult execute(GetCategoryCommand command) throws Exception {
        return new GetCategoryResult(categoryConverter.convert(categoryService.get(command.getCategoryId())));
    }

    @Override
    public Class getCommandType() {
        return GetCategoryCommand.class;
    }*/

    @Override
    public GetRewardResult execute(GetRewardCommand command) throws Exception {
        return null;
    }

    @Override
    public Class getCommandType() {
        return null;
    }
}
