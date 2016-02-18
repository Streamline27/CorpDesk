package lv.javaguru.java3.core.services.gallerycluster.handler.category;

import lv.javaguru.java3.core.commands.gallerycluster.category.GetCategoryLimitedImagesCommand;
import lv.javaguru.java3.core.commands.gallerycluster.category.GetCategoryLimitedImagesResult;
import lv.javaguru.java3.core.convertor.CategoryConverter;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksej_home on 2016.02.17..
 */
@Component
public class GetCategoryLimitedImagesCommandHandler
        implements DomainCommandHandler<GetCategoryLimitedImagesCommand, GetCategoryLimitedImagesResult> {

    @Autowired
    CategoryService categoryService;

    @Override
    public GetCategoryLimitedImagesResult execute(GetCategoryLimitedImagesCommand command) throws Exception {
        return new GetCategoryLimitedImagesResult(categoryService.getCategoryImagesLimited(
                command.getCategoryId(),
                command.getPage(),
                command.getDefinedSize()
        ));
    }

    @Override
    public Class getCommandType() {
        return GetCategoryLimitedImagesCommand.class;
    }
}