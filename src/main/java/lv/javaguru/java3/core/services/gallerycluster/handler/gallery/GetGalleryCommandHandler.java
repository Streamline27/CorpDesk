package lv.javaguru.java3.core.services.gallerycluster.handler.gallery;

import lv.javaguru.java3.core.convertor.GalleryConverter;
import lv.javaguru.java3.core.commands.gallerycluster.gallery.GetGalleryCommand;
import lv.javaguru.java3.core.commands.gallerycluster.gallery.GetGalleryResult;
import lv.javaguru.java3.core.database.gallerycluster.gallery.GalleryDAO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.gallery.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
@Component
public class GetGalleryCommandHandler
        implements DomainCommandHandler<GetGalleryCommand, GetGalleryResult> {

    @Autowired
    GalleryConverter galleryConverter;
    @Autowired
    GalleryService galleryService;
    @Autowired
    GalleryDAO galleryDAO;


    @Override
    public GetGalleryResult execute(GetGalleryCommand command) throws Exception {
        return new GetGalleryResult(galleryService.get(command.getGalleryId()));
    }

    @Override
    public Class getCommandType() {
        return GetGalleryCommand.class;
    }
}
