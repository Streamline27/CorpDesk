package lv.javaguru.java3.core.commands.gallerycluster.handler.image;

import lv.javaguru.java3.core.commands.gallerycluster.image.DeleteImageCommand;
import lv.javaguru.java3.core.commands.gallerycluster.image.DeleteImageResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class DeleteImageCommandHandler
        implements DomainCommandHandler<DeleteImageCommand, DeleteImageResult> {


    @Autowired private ImageService imageService;

    @Override
    public DeleteImageResult execute(DeleteImageCommand command) throws Exception {
        imageService.delete(command.getImageId());
        return new DeleteImageResult();

    }

    @Override
    public Class getCommandType() {
        return DeleteImageCommand.class;
    }
}
