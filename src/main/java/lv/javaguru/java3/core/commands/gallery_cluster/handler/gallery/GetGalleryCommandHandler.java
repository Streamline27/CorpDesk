package lv.javaguru.java3.core.commands.gallery_cluster.handler.gallery;

import lv.javaguru.java3.core.commands.gallery_cluster.converter.GalleryConverter;
import lv.javaguru.java3.core.commands.gallery_cluster.gallery.GetGalleryCommand;
import lv.javaguru.java3.core.commands.gallery_cluster.gallery.GetGalleryResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallery_cluster.gallery.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GetGalleryCommandHandler
        implements DomainCommandHandler<GetGalleryCommand, GetGalleryResult> {

    @Autowired
    GalleryConverter galleryConverter;
    @Autowired
    GalleryService galleryService;


    @Override
    public GetGalleryResult execute(GetGalleryCommand command) throws Exception {
        return new GetGalleryResult(galleryConverter.convert(galleryService.get(command.getGalleryId())));
    }

    @Override
    public Class getCommandType() {
        return GetGalleryCommand.class;
    }
}
