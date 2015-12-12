package lv.javaguru.java3.core.commands.gallerycluster.handler.category;

import lv.javaguru.java3.core.commands.gallerycluster.category.CreateCategoryCommand;
import lv.javaguru.java3.core.commands.gallerycluster.category.CreateCategoryResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.category.CategoryFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateCategoryCommandHandler
        implements DomainCommandHandler<CreateCategoryCommand, CreateCategoryResult> {

    @Autowired private CategoryFactory categoryFactory;

    @Override
    public CreateCategoryResult execute(CreateCategoryCommand command) throws Exception {
        return new CreateCategoryResult(categoryFactory.create(command.getCategoryDTO()));
    }

    @Override
    public Class getCommandType() {
        return CreateCategoryCommand.class;
    }
}
