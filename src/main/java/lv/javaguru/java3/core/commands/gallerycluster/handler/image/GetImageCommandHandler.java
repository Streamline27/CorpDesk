package lv.javaguru.java3.core.commands.gallerycluster.handler.image;

import lv.javaguru.java3.core.commands.gallerycluster.converter.ImageConverter;
import lv.javaguru.java3.core.commands.gallerycluster.image.GetImageCommand;
import lv.javaguru.java3.core.commands.gallerycluster.image.GetImageResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GetImageCommandHandler
        implements DomainCommandHandler<GetImageCommand, GetImageResult> {


    @Autowired private ImageService imageService;
    @Autowired private ImageConverter imageConverter;

    @Override
    public GetImageResult execute(GetImageCommand command) throws Exception {
        return new GetImageResult(imageConverter.convert(imageService.get(command.getImageId())));
    }

    @Override
    public Class getCommandType() {
        return GetImageCommand.class;
    }
}
