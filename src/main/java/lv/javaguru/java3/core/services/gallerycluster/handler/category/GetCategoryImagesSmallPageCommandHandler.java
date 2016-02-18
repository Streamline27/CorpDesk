package lv.javaguru.java3.core.services.gallerycluster.handler.category;

import lv.javaguru.java3.core.commands.gallerycluster.category.GetCategoryImagesSmallPageCommand;
import lv.javaguru.java3.core.commands.gallerycluster.category.GetCategoryImagesSmallPageResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksej_home on 2016.02.18..
 */
@Component
public class GetCategoryImagesSmallPageCommandHandler
        implements DomainCommandHandler<GetCategoryImagesSmallPageCommand, GetCategoryImagesSmallPageResult> {

    @Autowired
    CategoryService categoryService;

    @Override
    public GetCategoryImagesSmallPageResult execute(GetCategoryImagesSmallPageCommand command) throws Exception {
        return new GetCategoryImagesSmallPageResult(categoryService.getCategoryImagesSmall(
                command.getCategoryId(),
                command.getPage()
        ));
    }

    @Override
    public Class getCommandType() {
        return GetCategoryImagesSmallPageCommand.class;
    }
}