package lv.javaguru.java3.core.dto.gallerycluster;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GalleryDTOBuilder {
    protected String label;
    protected String description;
    protected boolean isActive;
    private long userId;
    private boolean allowRate;
    private boolean allowRateIcons;
    private List<CategoryDTO> categoryDTOs = new ArrayList<>();

    private GalleryDTOBuilder() {
    }

    public static GalleryDTOBuilder aGalleryDTO() {
        return new GalleryDTOBuilder();
    }

    public GalleryDTOBuilder withUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public GalleryDTOBuilder withAllowRate(boolean allowRate) {
        this.allowRate = allowRate;
        return this;
    }

    public GalleryDTOBuilder withAllowRateIcons(boolean allowRateIcons) {
        this.allowRateIcons = allowRateIcons;
        return this;
    }

    public GalleryDTOBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public GalleryDTOBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public GalleryDTOBuilder withIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public GalleryDTOBuilder withCategories(List<CategoryDTO> categoryDTOs) {
        this.categoryDTOs = categoryDTOs;
        return this;
    }

    public GalleryDTOBuilder but() {
        return aGalleryDTO().withUserId(userId)
                .withAllowRate(allowRate)
                .withAllowRateIcons(allowRateIcons)
                .withLabel(label)
                .withDescription(description)
                .withIsActive(isActive)
                .withCategories(categoryDTOs);

    }

    public GalleryDTO build() {
        GalleryDTO galleryDTO = new GalleryDTO();
        galleryDTO.setUserId(userId);
        galleryDTO.setAllowRate(allowRate);
        galleryDTO.setAllowRateIcons(allowRateIcons);
        galleryDTO.setLabel(label);
        galleryDTO.setDescription(description);
        galleryDTO.setIsActive(isActive);
        galleryDTO.setCategoryDTOs(categoryDTOs);
        return galleryDTO;
    }
}
