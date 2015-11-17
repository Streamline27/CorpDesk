package lv.javaguru.java3.core.commands.gallery_cluster.gallery;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.gallery_cluster.GalleryDTO;
import lv.javaguru.java3.core.dto.gallery_cluster.ImageDTO;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateGalleryResult implements DomainCommandResult{
    private final GalleryDTO galleryDTO;

    public CreateGalleryResult(GalleryDTO galleryDTO){
        this.galleryDTO = galleryDTO;
    }

    public GalleryDTO getGalleryDTO(){
        return galleryDTO;
    }
}
