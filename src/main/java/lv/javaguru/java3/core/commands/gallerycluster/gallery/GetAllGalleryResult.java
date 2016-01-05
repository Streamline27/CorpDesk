package lv.javaguru.java3.core.commands.gallerycluster.gallery;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;

import java.util.List;

/**
 * Created by Aleksej_home on 2016.01.05..
 */
public class GetAllGalleryResult implements DomainCommandResult {
    private final List<GalleryDTO> galleryDTOs;

    public GetAllGalleryResult(List<GalleryDTO> galleryDTOs){
        this.galleryDTOs = galleryDTOs;
    }

    public List<GalleryDTO> getAllGalleryDTOs(){
        return galleryDTOs;
    }
}
