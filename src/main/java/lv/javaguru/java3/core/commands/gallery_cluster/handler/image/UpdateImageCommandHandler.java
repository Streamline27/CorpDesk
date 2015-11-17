package lv.javaguru.java3.core.commands.gallery_cluster.handler.image;

import lv.javaguru.java3.core.commands.gallery_cluster.image.UpdateImageCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.image.UpdateImageResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateImageCommandHandler
        implements DomainCommandHandler<UpdateImageCommand, UpdateImageResult> {

 /*   @Autowired CategoryService categoryService;

    @Override
    public UpdateCategoryResult execute(UpdateCategoryCommand command) throws Exception {
        return new UpdateCategoryResult(categoryService.update(command.getCategoryDTO()));
    }

    @Override
    public Class getCommandType() {
        return UpdateCategoryCommand.class;
    }*/

    @Override
    public UpdateImageResult execute(UpdateImageCommand command) throws Exception {
        return null;
    }

    @Override
    public Class getCommandType() {
        return null;
    }
}
