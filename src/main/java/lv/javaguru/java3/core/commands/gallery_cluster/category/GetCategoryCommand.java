package lv.javaguru.java3.core.commands.gallery_cluster.category;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GetCategoryCommand implements DomainCommand<GetCategoryResult> {
    private final long id;

    public GetCategoryCommand(long id){
        this.id = id;
    }

    public long getCategoryId(){
        return id;
    }
}
