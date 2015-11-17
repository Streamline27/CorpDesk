package lv.javaguru.java3.core.commands.gallery_cluster.handler.category;

import lv.javaguru.java3.core.commands.gallery_cluster.category.UpdateCategoryCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.category.UpdateCategoryResult;
import lv.javaguru.java3.core.commands.gallery_cluster.converter.CategoryConverter;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallery_cluster.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateCategoryCommandHandler
        implements DomainCommandHandler<UpdateCategoryCommand, UpdateCategoryResult> {

    @Autowired CategoryService categoryService;

    @Override
    public UpdateCategoryResult execute(UpdateCategoryCommand command) throws Exception {
        return new UpdateCategoryResult(categoryService.update(command.getCategoryDTO()));
    }

    @Override
    public Class getCommandType() {
        return UpdateCategoryCommand.class;
    }
}
