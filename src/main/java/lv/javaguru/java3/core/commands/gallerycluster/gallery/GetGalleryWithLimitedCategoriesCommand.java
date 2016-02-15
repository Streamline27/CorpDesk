package lv.javaguru.java3.core.commands.gallerycluster.gallery;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Aleksej_home on 2016.02.14..
 */
public class GetGalleryWithLimitedCategoriesCommand implements DomainCommand<GetGalleryResult>{
        private final long id;

        public GetGalleryWithLimitedCategoriesCommand(long id){
            this.id = id;
        }

        public long getGalleryId(){
            return id;
        }

}
