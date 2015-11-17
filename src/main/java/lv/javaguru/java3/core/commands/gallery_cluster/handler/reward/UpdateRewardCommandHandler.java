package lv.javaguru.java3.core.commands.gallery_cluster.handler.reward;

import lv.javaguru.java3.core.commands.gallery_cluster.reward.UpdateRewardCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.reward.UpdateRewardResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateRewardCommandHandler
        implements DomainCommandHandler<UpdateRewardCommand, UpdateRewardResult> {

  /*  @Autowired CategoryService categoryService;

    @Override
    public UpdateCategoryResult execute(UpdateCategoryCommand command) throws Exception {
        return new UpdateCategoryResult(categoryService.update(command.getCategoryDTO()));
    }

    @Override
    public Class getCommandType() {
        return UpdateCategoryCommand.class;
    }*/

    @Override
    public UpdateRewardResult execute(UpdateRewardCommand command) throws Exception {
        return null;
    }

    @Override
    public Class getCommandType() {
        return null;
    }
}
