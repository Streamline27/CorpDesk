package lv.javaguru.java3.core.services.gallerycluster.handler.image;

import lv.javaguru.java3.core.commands.gallerycluster.image.CreateImageCommand;
import lv.javaguru.java3.core.commands.gallerycluster.image.CreateImageResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.image.ImageFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateImageCommandHandler
        implements DomainCommandHandler<CreateImageCommand, CreateImageResult> {

    @Autowired private ImageFactory imageFactory;

    @Override
    public CreateImageResult execute(CreateImageCommand command) throws Exception {
        return new CreateImageResult(imageFactory.createDTO(command.getImageDTO()));
    }

    @Override
    public Class getCommandType() {
        return CreateImageCommand.class;
    }
}
