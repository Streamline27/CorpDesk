package lv.javaguru.java3.core.services.gallery_cluster.category;

import lv.javaguru.java3.core.dto.gallery_cluster.CategoryDTO;
import lv.javaguru.java3.core.services.gallery_cluster.Validator;

import java.sql.Date;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class CategoryValidatorImpl extends Validator implements CategoryValidator{

    private final String BASE = "Category ";

    @Override
    public void validate(long galleryId,
                         long imgId,
                         String label,
                         String description,
                         boolean isActive,
                         boolean allowRate,
                         boolean allowRateIcons,
                         Date modified) {

        validateDecimal(galleryId,BASE + "gallery id");
        validateDecimal(imgId,BASE + "image id");
        validateText(label, BASE + "label");
        validateText(description, BASE + "description");
        validateState(isActive, BASE + "active state");
        validateState(allowRate, BASE + "allowRate");
        validateState(allowRateIcons, BASE + "allowRateIcons");
        validateDate(modified, BASE + "modified");

       validateGalleryId(galleryId);
       validateImageId(imgId);
       validateLabel(label);
       validateDescription(description);
       validateIsActive(isActive);
       validateAllowRate(allowRate);
       validateAllowRateIcons(allowRateIcons);
       validateModified(modified);


    }

    @Override
    public void validate(long imgId,
                         String label,
                         String description,
                         boolean isActive,
                         boolean allowRate,
                         boolean allowRateIcons,
                         Date modified) {

        validateDecimal(imgId,BASE + "image id");
        validateText(label, BASE + "label");
        validateText(description, BASE + "description");
        validateState(isActive, BASE + "active state");
        validateState(allowRate, BASE + "allowRate");
        validateState(allowRateIcons, BASE + "allowRateIcons");
        validateDate(modified, BASE + "modified");

        validateImageId(imgId);
        validateLabel(label);
        validateDescription(description);
        validateIsActive(isActive);
        validateAllowRate(allowRate);
        validateAllowRateIcons(allowRateIcons);
        validateModified(modified);


    }

    @Override
    public void validate(CategoryDTO categoryDTO) {
        validateDecimal(categoryDTO.getImgId(), BASE + "image id");
        validateText(categoryDTO.getLabel(), BASE + "label");
        validateText(categoryDTO.getDescription(), BASE + "description");
        validateState(categoryDTO.isActive(), BASE + "active state");
        validateState(categoryDTO.getAllowRate(), BASE + "allowRate");
        validateState(categoryDTO.getAllowRateIcons(), BASE + "allowRateIcons");
        validateDate(categoryDTO.getModifed(), BASE + "modified");

        validateImageId(categoryDTO.getImgId());
        validateLabel(categoryDTO.getLabel());
        validateDescription(categoryDTO.getDescription());
        validateIsActive(categoryDTO.isActive());
        validateAllowRate(categoryDTO.getAllowRate());
        validateAllowRateIcons(categoryDTO.getAllowRateIcons());
        validateModified(categoryDTO.getModifed());
    }

    private void validateGalleryId(long galleryId) {

    }

    private void validateImageId(long imgId) {

    }
    private void validateLabel(String label) {

    }
    private void validateDescription(String description) {

    }
    private void validateIsActive(boolean isActive) {

    }
    private void validateAllowRate(boolean allowRate) {

    }
    private void validateAllowRateIcons(boolean allowRateIcons) {

    }
    private void validateModified(Date modified) {

    }
}
