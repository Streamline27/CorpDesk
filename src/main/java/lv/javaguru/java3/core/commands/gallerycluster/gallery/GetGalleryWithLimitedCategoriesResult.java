package lv.javaguru.java3.core.commands.gallerycluster.gallery;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;

/**
 * Created by Aleksej_home on 2016.02.14..
 */
public class GetGalleryWithLimitedCategoriesResult implements DomainCommandResult{
        private final GalleryDTO galleryDTO;

        public GetGalleryWithLimitedCategoriesResult(GalleryDTO galleryDTO){
            this.galleryDTO = galleryDTO;
        }

        public GalleryDTO getGalleryDTO(){
            return galleryDTO;
        }

}
