package lv.javaguru.java3.core.commands.gallerycluster.category;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryDTO;

/**
 * Created by Aleksej_home on 2016.02.18..
 */
public class GetCategoryImagesSmallPageResult implements DomainCommandResult {
    private final CategoryDTO categoryDTO;

    public GetCategoryImagesSmallPageResult(CategoryDTO categoryDTO){
        this.categoryDTO = categoryDTO;
    }

    public CategoryDTO getCategoryDTO(){
        return categoryDTO;
    }
}