package lv.javaguru.java3.core.commands.gallery_cluster.category;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class DeleteCategoryCommand implements DomainCommand<DeleteCategoryResult> {
    private final long id;

    public DeleteCategoryCommand(long id){
        this.id = id;
    }

    public long getCategoryId(){
        return id;
    }
}
