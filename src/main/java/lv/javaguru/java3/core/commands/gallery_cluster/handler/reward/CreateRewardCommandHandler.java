package lv.javaguru.java3.core.commands.gallery_cluster.handler.reward;

import lv.javaguru.java3.core.commands.gallery_cluster.reward.CreateRewardCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.reward.CreateRewardResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateRewardCommandHandler
        implements DomainCommandHandler<CreateRewardCommand, CreateRewardResult> {

 /*   @Autowired private CategoryFactory categoryFactory;
   // @Autowired private CategoryConverter categoryConverter;

    @Override
    public CreateCategoryResult execute(CreateCategoryCommand command) throws Exception {
        return new CreateCategoryResult(categoryFactory.create(command.getCategoryDTO()));
    }

    @Override
    public Class getCommandType() {
        return CreateCategoryCommand.class;
    }*/

    @Override
    public CreateRewardResult execute(CreateRewardCommand command) throws Exception {
        return null;
    }

    @Override
    public Class getCommandType() {
        return null;
    }
}
