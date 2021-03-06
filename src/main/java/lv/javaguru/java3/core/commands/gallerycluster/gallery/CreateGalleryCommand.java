package lv.javaguru.java3.core.commands.gallerycluster.gallery;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateGalleryCommand implements DomainCommand<CreateGalleryResult> {
  private final GalleryDTO galleryDTO;

    public CreateGalleryCommand(GalleryDTO galleryDTO){
        this.galleryDTO = galleryDTO;
    }

    public GalleryDTO getGalleryDTO(){
        return galleryDTO;
    }
}
