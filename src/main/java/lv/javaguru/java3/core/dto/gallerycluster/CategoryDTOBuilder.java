package lv.javaguru.java3.core.dto.gallerycluster;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class CategoryDTOBuilder {
    protected String label;
    protected String description;
    protected boolean isActive;
    private long id;
    private long galleryId;
    private long imgId;
    private boolean allowRate;
    private boolean allowRateIcons;
    private Date modified;

    private CategoryDTOBuilder() {
    }

    public static CategoryDTOBuilder aCategoryDTO() {
        return new CategoryDTOBuilder();
    }

    public CategoryDTOBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public CategoryDTOBuilder withGalleryId(long galleryId) {
        this.galleryId = galleryId;
        return this;
    }

    public CategoryDTOBuilder withImgId(long imgId) {
        this.imgId = imgId;
        return this;
    }

    public CategoryDTOBuilder withAllowRate(boolean allowRate) {
        this.allowRate = allowRate;
        return this;
    }

    public CategoryDTOBuilder withAllowRateIcons(boolean allowRateIcons) {
        this.allowRateIcons = allowRateIcons;
        return this;
    }

    public CategoryDTOBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public CategoryDTOBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryDTOBuilder withIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }
    public CategoryDTOBuilder withModified(Date modified) {
        this.modified = modified;
        return this;
    }

    public CategoryDTOBuilder but() {
        return aCategoryDTO().withId(id).withGalleryId(galleryId).withImgId(imgId).withAllowRate(allowRate).withAllowRateIcons(allowRateIcons).withLabel(label).withDescription(description).withIsActive(isActive).withModified(modified);
    }

    public CategoryDTO build() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(id);
        categoryDTO.setGalleryId(galleryId);
        categoryDTO.setImgId(imgId);
        categoryDTO.setAllowRate(allowRate);
        categoryDTO.setAllowRateIcons(allowRateIcons);
        categoryDTO.setLabel(label);
        categoryDTO.setDescription(description);
        categoryDTO.setIsActive(isActive);
        categoryDTO.setModifed(modified);
        return categoryDTO;
    }
}
