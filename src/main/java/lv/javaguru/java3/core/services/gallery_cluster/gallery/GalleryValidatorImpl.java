package lv.javaguru.java3.core.services.gallery_cluster.gallery;

import lv.javaguru.java3.core.dto.gallery_cluster.GalleryDTO;
import lv.javaguru.java3.core.services.gallery_cluster.Validator;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
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
}
