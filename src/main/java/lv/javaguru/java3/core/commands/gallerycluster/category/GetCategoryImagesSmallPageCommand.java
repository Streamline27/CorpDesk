package lv.javaguru.java3.core.commands.gallerycluster.category;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Aleksej_home on 2016.02.18..
 */
public class GetCategoryImagesSmallPageCommand implements DomainCommand<GetCategoryImagesSmallPageResult> {

    private final Long id;
    private final int page;
    private static final int DEFAULT_PAGE_SIZE = 1;

    public GetCategoryImagesSmallPageCommand(Long id, int page){
        this.id = id;
        this.page = page;
    }

    public long getCategoryId(){
        return id;
    }
    public int getPage(){
        return page;
    }
    public int getDefinedSize(){
        return DEFAULT_PAGE_SIZE;
    }
}