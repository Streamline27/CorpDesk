package lv.javaguru.java3.core.services.gallerycluster.handler.gallery;

import lv.javaguru.java3.core.commands.gallerycluster.gallery.GetAllGalleryCommand;
import lv.javaguru.java3.core.commands.gallerycluster.gallery.GetAllGalleryResult;
import lv.javaguru.java3.core.convertor.GalleryConverter;
import lv.javaguru.java3.core.database.gallerycluster.gallery.GalleryDAO;
import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.gallery.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksej_home on 2016.01.05..
 */
@Component
public class GetAllGalleryCommandHandler  implements DomainCommandHandler<GetAllGalleryCommand, GetAllGalleryResult> {

    @Autowired
    GalleryConverter galleryConverter;
    @Autowired
    GalleryService galleryService;
    @Autowired
    GalleryDAO galleryDAO;


    @Override
    public GetAllGalleryResult execute(GetAllGalleryCommand command) throws Exception {
        List<GalleryDTO> galleryDTOs = new ArrayList<>();

        galleryService.getAll().forEach(
                e -> galleryDTOs.add(galleryConverter.convert(e))
        );
        return new GetAllGalleryResult(galleryDTOs);
    }

    @Override
    public Class getCommandType() {
        return GetAllGalleryCommand.class;
    }
}