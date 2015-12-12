package lv.javaguru.java3.core.commands.gallerycluster.handler.category;

import lv.javaguru.java3.core.commands.gallerycluster.category.UpdateCategoryCommand;
import lv.javaguru.java3.core.commands.gallerycluster.category.UpdateCategoryResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.category.CategoryService;
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
