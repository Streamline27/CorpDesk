package lv.javaguru.java3.core.commands.gallery_cluster.gallery;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.gallery_cluster.GalleryDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateGalleryResult implements DomainCommandResult {
    private final GalleryDTO galleryDTO;

    public UpdateGalleryResult(GalleryDTO galleryDTO){
        this.galleryDTO = galleryDTO;
    }

    public GalleryDTO getGalleryDTO(){
        return galleryDTO;
    }
}
