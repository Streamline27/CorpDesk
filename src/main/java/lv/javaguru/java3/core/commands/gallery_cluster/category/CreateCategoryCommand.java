package lv.javaguru.java3.core.commands.gallery_cluster.category;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.dto.gallery_cluster.CategoryDTO;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateCategoryCommand implements DomainCommand<CreateCategoryResult> {
  private final CategoryDTO categoryDTO;

    public CreateCategoryCommand(CategoryDTO categoryDTO){
        this.categoryDTO = categoryDTO;
    }

    public CategoryDTO getCategoryDTO(){
        return categoryDTO;
    }
}
