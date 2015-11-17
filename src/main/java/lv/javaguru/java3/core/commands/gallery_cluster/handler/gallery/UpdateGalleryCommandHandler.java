package lv.javaguru.java3.core.commands.gallery_cluster.handler.gallery;

import lv.javaguru.java3.core.commands.gallery_cluster.gallery.UpdateGalleryCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.gallery.UpdateGalleryResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallery_cluster.gallery.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class UpdateGalleryCommandHandler
        implements DomainCommandHandler<UpdateGalleryCommand, UpdateGalleryResult> {

    @Autowired
    GalleryService galleryService;


    @Override
    public UpdateGalleryResult execute(UpdateGalleryCommand command) throws Exception {
        return new UpdateGalleryResult(galleryService.update(command.getGalleryDTO()));
    }

    @Override
    public Class getCommandType() {
        return UpdateGalleryCommand.class;
    }
}
