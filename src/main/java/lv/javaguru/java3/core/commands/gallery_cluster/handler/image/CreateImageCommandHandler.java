package lv.javaguru.java3.core.commands.gallery_cluster.handler.image;

import lv.javaguru.java3.core.commands.gallery_cluster.image.CreateImageCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.image.CreateImageResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateImageCommandHandler
        implements DomainCommandHandler<CreateImageCommand, CreateImageResult> {

  /*  @Autowired private CategoryFactory categoryFactory;
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
    public CreateImageResult execute(CreateImageCommand command) throws Exception {
        return null;
    }

    @Override
    public Class getCommandType() {
        return null;
    }
}
