package lv.javaguru.java3.core.commands.gallerycluster.handler.image;

import lv.javaguru.java3.core.commands.gallerycluster.image.UpdateImageCommand;
import lv.javaguru.java3.core.commands.gallerycluster.image.UpdateImageResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateImageCommandHandler
        implements DomainCommandHandler<UpdateImageCommand, UpdateImageResult> {


    @Autowired private ImageService imageService;

    @Override
    public UpdateImageResult execute(UpdateImageCommand command) throws Exception {
        return new UpdateImageResult(imageService.update(command.getImageDTO()));
    }

    @Override
    public Class getCommandType() {
        return UpdateImageCommand.class;
    }
}
