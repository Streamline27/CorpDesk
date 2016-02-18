package lv.javaguru.java3.core.dto.gallerycluster;

/**
 * Created by Aleksej_home on 2016.02.16..
 */
public class CategoryPageDTOBuilder {
    protected String label;
    protected String description;
    protected boolean isActive;
    private Long id;
    private Boolean allowRate;
    private Boolean allowRateIcons;
    private Long imageId;
    private String imageThumb;
    private String imageLabel;
    private String imageDescription;
    private Boolean imageIsActive;
    private Long imgCount;

    private CategoryPageDTOBuilder() {
    }

    public static CategoryPageDTOBuilder aCategoryPageDTO() {
        return new CategoryPageDTOBuilder();
    }

    public CategoryPageDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryPageDTOBuilder withAllowRate(Boolean allowRate) {
        this.allowRate = allowRate;
        return this;
    }

    public CategoryPageDTOBuilder withAllowRateIcons(Boolean allowRateIcons) {
        this.allowRateIcons = allowRateIcons;
        return this;
    }

    public CategoryPageDTOBuilder withImageId(Long imageId) {
        this.imageId = imageId;
        return this;
    }

    public CategoryPageDTOBuilder withImageThumb(String imageThumb) {
        this.imageThumb = imageThumb;
        return this;
    }

    public CategoryPageDTOBuilder withImageLabel(String imageLabel) {
        this.imageLabel = imageLabel;
        return this;
    }

    public CategoryPageDTOBuilder withImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
        return this;
    }

    public CategoryPageDTOBuilder withImageIsActive(Boolean imageIsActive) {
        this.imageIsActive = imageIsActive;
        return this;
    }

    public CategoryPageDTOBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public CategoryPageDTOBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryPageDTOBuilder withIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public CategoryPageDTOBuilder withImagesCount(Long imgCount) {
        this.imgCount = imgCount;
        return this;
    }

    public CategoryPageDTOBuilder but() {
        return aCategoryPageDTO().withId(id).withAllowRate(allowRate).withAllowRateIcons(allowRateIcons).withImageId(imageId).withImageThumb(imageThumb).withImageLabel(imageLabel).withImageDescription(imageDescription).withImageIsActive(imageIsActive).withLabel(label).withDescription(description).withIsActive(isActive);
    }

    public CategoryPageDTO build() {
        CategoryPageDTO categoryPageDTO = new CategoryPageDTO();
        categoryPageDTO.setId(id);
        categoryPageDTO.setAllowRate(allowRate);
        categoryPageDTO.setAllowRateIcons(allowRateIcons);
        categoryPageDTO.setImageId(imageId);
        categoryPageDTO.setImageThumb(imageThumb);
        categoryPageDTO.setImageLabel(imageLabel);
        categoryPageDTO.setImageDescription(imageDescription);
        categoryPageDTO.setImageIsActive(imageIsActive);
        categoryPageDTO.setLabel(label);
        categoryPageDTO.setDescription(description);
        categoryPageDTO.setIsActive(isActive);
        categoryPageDTO.setImgCount(imgCount);
        return categoryPageDTO;
    }
}
