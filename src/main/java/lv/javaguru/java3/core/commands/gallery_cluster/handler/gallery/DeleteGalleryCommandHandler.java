package lv.javaguru.java3.core.commands.gallery_cluster.handler.gallery;

import lv.javaguru.java3.core.commands.gallery_cluster.gallery.DeleteGalleryCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.gallery.DeleteGalleryResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallery_cluster.gallery.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class DeleteGalleryCommandHandler
        implements DomainCommandHandler<DeleteGalleryCommand, DeleteGalleryResult> {

    @Autowired GalleryService galleryService;



    @Override
    public DeleteGalleryResult execute(DeleteGalleryCommand command) throws Exception {
        galleryService.delete(command.getGalleryId());
        return new DeleteGalleryResult();
    }

    @Override
    public Class getCommandType() {
        return DeleteGalleryCommand.class;
    }
}
