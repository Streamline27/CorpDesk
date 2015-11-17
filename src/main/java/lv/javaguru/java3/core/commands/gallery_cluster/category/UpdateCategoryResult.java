package lv.javaguru.java3.core.commands.gallery_cluster.category;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.gallery_cluster.CategoryDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateCategoryResult implements DomainCommandResult {
    private final CategoryDTO categoryDTO;

    public UpdateCategoryResult(CategoryDTO categoryDTO){
        this.categoryDTO = categoryDTO;
    }

    public CategoryDTO getCategoryDTO(){
        return categoryDTO;
    }
}
