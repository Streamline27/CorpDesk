package lv.javaguru.java3.core.commands.gallerycluster.gallery;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Aleksej_home on 2016.02.14..
 */
public class GetGalleryWithLimitedCategoriesCommand implements DomainCommand<GetGalleryWithLimitedCategoriesResult>{
        private final long id;
        private final int page;
        private static final int DEFAULT_PAGE_SIZE = 8;

        public GetGalleryWithLimitedCategoriesCommand(long id, int page){
            this.id = id;
            this.page = page;
        }

        public long getGalleryId(){
            return id;
        }
        public int getPage(){
        return page;
    }
        public int getPageSize(){
        return DEFAULT_PAGE_SIZE;
    }

}
