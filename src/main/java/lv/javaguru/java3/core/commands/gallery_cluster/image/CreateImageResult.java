package lv.javaguru.java3.core.commands.gallery_cluster.image;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.gallery_cluster.ImageDTO;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateImageResult implements DomainCommandResult{
    private final ImageDTO imageDTO;

    public CreateImageResult(ImageDTO imageDTO){
        this.imageDTO = imageDTO;
    }

    public ImageDTO getImageDTO(){
        return imageDTO;
    }
}