package lv.javaguru.java3.core.commands.gallerycluster.image;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.dto.gallerycluster.ImageDTO;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateImageCommand implements DomainCommand<CreateImageResult> {
  private final ImageDTO imageDTO;

    public CreateImageCommand(ImageDTO imageDTO){
        this.imageDTO = imageDTO;
    }

    public ImageDTO getImageDTO(){
        return imageDTO;
    }
}
