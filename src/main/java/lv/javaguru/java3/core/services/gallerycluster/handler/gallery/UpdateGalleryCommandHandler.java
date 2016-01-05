package lv.javaguru.java3.core.services.gallerycluster.handler.gallery;

import lv.javaguru.java3.core.commands.gallerycluster.gallery.UpdateGalleryCommand;
import lv.javaguru.java3.core.commands.gallerycluster.gallery.UpdateGalleryResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.gallery.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
@Component
public class UpdateGalleryCommandHandler
        implements DomainCommandHandler<UpdateGalleryCommand, UpdateGalleryResult> {

    @Autowired
    GalleryService galleryService;


    @Override
    public UpdateGalleryResult execute(UpdateGalleryCommand command) throws Exception {
        return new UpdateGalleryResult(galleryService.updateDTO(command.getGalleryDTO()));
    }

    @Override
    public Class getCommandType() {
        return UpdateGalleryCommand.class;
    }
}
