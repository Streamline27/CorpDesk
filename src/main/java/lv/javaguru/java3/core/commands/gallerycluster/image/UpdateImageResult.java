package lv.javaguru.java3.core.commands.gallerycluster.image;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.gallerycluster.ImageDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateImageResult implements DomainCommandResult {
    private final ImageDTO imageDTO;

    public UpdateImageResult(ImageDTO imageDTO){
        this.imageDTO = imageDTO;
    }

    public ImageDTO getImageDTO(){
        return imageDTO;
    }
}
