package lv.javaguru.java3.core.services.gallerycluster.image;

import lv.javaguru.java3.core.dto.gallerycluster.ImageDTO;
import lv.javaguru.java3.core.services.gallerycluster.Validator;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class ImageValidatorImpl extends Validator implements ImageValidator{

    private final String BASE = "Image ";

    @Override
    public void validate(int rate,
                         String label,
                         String thumb,
                         String middle,
                         String orig,
                         String description,
                         boolean isActive,
                         boolean allowRate,
                         boolean allowRateIcons,
                         Date modified) {
        validateDecimal(rate,BASE + "rate");
        validateText(label, BASE + "label");
        validateText(thumb, BASE + "thumb");
        validateText(middle, BASE + "middle");
        validateText(orig, BASE + "orig");
        validateText(description, BASE + "description");
        validateState(isActive, BASE + "active state");
        validateState(allowRate, BASE + "allowRate");
        validateState(allowRateIcons, BASE + "allowRateIcons");
        validateDate(modified, BASE + "modified");

    }

    private void validateLabel(String label) {

    }

    @Override
    public void validate(ImageDTO imageDTO) {
        validateDecimal(imageDTO.getRate(),BASE + "rate");
        validateText(imageDTO.getLabel(), BASE + "label");
        validateText(imageDTO.getThumb(), BASE + "thumb");
        validateText(imageDTO.getMiddle(), BASE + "middle");
        validateText(imageDTO.getOrig(), BASE + "orig");
        validateText(imageDTO.getDescription(), BASE + "description");
        validateState(imageDTO.isActive(), BASE + "active state");
        validateState(imageDTO.getAllowRate(), BASE + "allowRate");
        validateState(imageDTO.getAllowRateIcons(), BASE + "allowRateIcons");
        validateDate(imageDTO.getModifed(), BASE + "modified");
    }
}
