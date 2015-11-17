package lv.javaguru.java3.core.commands.gallery_cluster.handler.category;

import lv.javaguru.java3.core.commands.gallery_cluster.category.GetCategoryCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.category.GetCategoryResult;
import lv.javaguru.java3.core.commands.gallery_cluster.converter.CategoryConverter;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallery_cluster.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GetCategoryCommandHandler
        implements DomainCommandHandler<GetCategoryCommand, GetCategoryResult> {

    @Autowired CategoryService categoryService;
    @Autowired CategoryConverter categoryConverter;

    @Override
    public GetCategoryResult execute(GetCategoryCommand command) throws Exception {
        return new GetCategoryResult(categoryConverter.convert(categoryService.get(command.getCategoryId())));
    }

    @Override
    public Class getCommandType() {
        return GetCategoryCommand.class;
    }
}
