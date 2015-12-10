package lv.javaguru.java3.core.commands.gallerycluster.gallery;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GetGalleryResult implements DomainCommandResult {
    private final GalleryDTO galleryDTO;

    public GetGalleryResult(GalleryDTO galleryDTO){
        this.galleryDTO = galleryDTO;
    }

    public GalleryDTO getGalleryDTO(){
        return galleryDTO;
    }
}
