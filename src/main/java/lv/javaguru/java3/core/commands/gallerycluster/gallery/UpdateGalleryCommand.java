package lv.javaguru.java3.core.commands.gallerycluster.gallery;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateGalleryCommand implements DomainCommand<UpdateGalleryResult> {
    private final GalleryDTO galleryDTO;

    public UpdateGalleryCommand(GalleryDTO galleryDTO){
        this.galleryDTO = galleryDTO;
    }

    public GalleryDTO getGalleryDTO(){
        return galleryDTO;
    }
}
