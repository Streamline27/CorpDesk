package lv.javaguru.java3.core.commands.gallerycluster.handler.gallery;


import lv.javaguru.java3.core.commands.gallerycluster.gallery.CreateGalleryCommand;
import lv.javaguru.java3.core.commands.gallerycluster.gallery.CreateGalleryResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.gallery.GalleryFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.16..
 */
public class CreateGalleryCommandHandler
        implements DomainCommandHandler<CreateGalleryCommand, CreateGalleryResult> {

    @Autowired private GalleryFactory galleryFactory;


    @Override
    public CreateGalleryResult execute(CreateGalleryCommand command) throws Exception {
        return new CreateGalleryResult(galleryFactory.create(command.getGalleryDTO()));
    }

    @Override
    public Class getCommandType() {
        return CreateGalleryCommand.class;
    }
}
