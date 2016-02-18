package lv.javaguru.java3.core.services.gallerycluster.gallery;

import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryPageDTO;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;
import lv.javaguru.java3.core.services.gallerycluster.Validator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
//@Service
@Component
public class GalleryValidatorImpl extends Validator implements GalleryValidator{

    private final String BASE = "Gallery ";

    @Override
    public void validate(String label,
                         String description,
                         boolean isActive,
                         boolean allowRate,
                         boolean allowRateIcons) {
        validateText(label, BASE + "label");
        validateText(description, BASE + "description");
        validateState(isActive, BASE + "active state");
        validateState(allowRate, BASE + "allowRate");
        validateState(allowRateIcons, BASE + "allowRateIcons");
    }

    private void validateLabel(String label) {

    }

    @Override
    public void validate(GalleryDTO galleryDTO) {
        validateText(galleryDTO.getLabel(), BASE + "label");
        validateText(galleryDTO.getDescription(), BASE + "description");
        validateState(galleryDTO.isActive(), BASE + "active state");
        validateState(galleryDTO.getAllowRate(), BASE + "allowRate");
        validateState(galleryDTO.getAllowRateIcons(), BASE + "allowRateIcons");
    }



    @Override
    @Deprecated
    public void validate(CategoryPageDTO categoryPageDTO) {

    }
}
