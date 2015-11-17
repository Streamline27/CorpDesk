package lv.javaguru.java3.core.commands.gallery_cluster.handler.reward;

import lv.javaguru.java3.core.commands.gallery_cluster.reward.DeleteRewardCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.reward.DeleteRewardResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class DeleteRewardCommandHandler
        implements DomainCommandHandler<DeleteRewardCommand, DeleteRewardResult> {

   /* @Autowired CategoryService categoryService;

    @Override
    public DeleteCategoryResult execute(DeleteCategoryCommand command) throws Exception {
        long id = command.getCategoryId();
        if (id==0)
            throw new Exception();
        else
            categoryService.delete(id);
        return new DeleteCategoryResult();
    }

    @Override
    public Class getCommandType() {
        return DeleteCategoryCommand.class;
    }*/

    @Override
    public DeleteRewardResult execute(DeleteRewardCommand command) throws Exception {
        return null;
    }

    @Override
    public Class getCommandType() {
        return null;
    }
}
