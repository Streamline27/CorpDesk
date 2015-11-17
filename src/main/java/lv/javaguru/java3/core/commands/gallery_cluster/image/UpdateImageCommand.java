package lv.javaguru.java3.core.commands.gallery_cluster.image;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.dto.gallery_cluster.ImageDTO;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateImageCommand implements DomainCommand<UpdateImageResult> {
    private final ImageDTO imageDTO;

    public UpdateImageCommand(ImageDTO imageDTO){
        this.imageDTO = imageDTO;
    }

    public ImageDTO getImageDTO(){
        return imageDTO;
    }
}
