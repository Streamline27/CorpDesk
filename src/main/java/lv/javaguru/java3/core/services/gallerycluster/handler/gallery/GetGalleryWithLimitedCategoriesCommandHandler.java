package lv.javaguru.java3.core.services.gallerycluster.handler.gallery;

import lv.javaguru.java3.core.commands.gallerycluster.gallery.GetGalleryWithLimitedCategoriesCommand;
import lv.javaguru.java3.core.commands.gallerycluster.gallery.GetGalleryWithLimitedCategoriesResult;
import lv.javaguru.java3.core.convertor.GalleryConverter;
import lv.javaguru.java3.core.database.gallerycluster.gallery.GalleryDAO;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryPageDTO;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.gallerycluster.gallery.GalleryService;
import lv.javaguru.java3.core.services.user.exception.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Aleksej_home on 2016.02.15..
 */
@Component
public class GetGalleryWithLimitedCategoriesCommandHandler
        implements DomainCommandHandler<GetGalleryWithLimitedCategoriesCommand, GetGalleryWithLimitedCategoriesResult> {

    @Autowired
    GalleryConverter galleryConverter;
    @Autowired
    GalleryService galleryService;
    @Autowired
    GalleryDAO galleryDAO;


    @Override
    public GetGalleryWithLimitedCategoriesResult execute(GetGalleryWithLimitedCategoriesCommand command)
            throws Exception {
       // return new GetGalleryResult(galleryConverter.convert(galleryService.get(command.getGalleryId())));
        GalleryDTO galleryDTO = galleryService.getWithPagingList(
                command.getGalleryId(),
                command.getPage(),
                command.getPageSize());
        return new GetGalleryWithLimitedCategoriesResult(galleryDTO);
    }

    @Override
    public Class getCommandType() {
        return GetGalleryWithLimitedCategoriesCommand.class;
    }
}
