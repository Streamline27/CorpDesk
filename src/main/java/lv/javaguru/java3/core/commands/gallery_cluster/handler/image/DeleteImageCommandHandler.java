package lv.javaguru.java3.core.commands.gallery_cluster.handler.image;

import lv.javaguru.java3.core.commands.gallery_cluster.image.DeleteImageCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.image.DeleteImageResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class DeleteImageCommandHandler
        implements DomainCommandHandler<DeleteImageCommand, DeleteImageResult> {

  /*  @Autowired CategoryService categoryService;

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
    public DeleteImageResult execute(DeleteImageCommand command) throws Exception {
        return null;
    }

    @Override
    public Class getCommandType() {
        return null;
    }
}
