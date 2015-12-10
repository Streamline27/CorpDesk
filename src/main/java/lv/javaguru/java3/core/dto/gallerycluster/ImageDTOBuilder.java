package lv.javaguru.java3.core.dto.gallerycluster;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class ImageDTOBuilder {
    protected String label;
    protected String description;
    protected boolean isActive;
    private long id;
    private String thumb;
    private String middle;
    private String orig;
    private int rate;
    private boolean allowRate;
    private boolean allowRateIcons;
    private Timestamp created;
    private Date modified;

    private ImageDTOBuilder() {
    }

    public static ImageDTOBuilder anImageDTO() {
        return new ImageDTOBuilder();
    }

    public ImageDTOBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public ImageDTOBuilder withThumb(String thumb) {
        this.thumb = thumb;
        return this;
    }

    public ImageDTOBuilder withMiddle(String middle) {
        this.middle = middle;
        return this;
    }

    public ImageDTOBuilder withOrig(String orig) {
        this.orig = orig;
        return this;
    }

    public ImageDTOBuilder withRate(int rate) {
        this.rate = rate;
        return this;
    }

    public ImageDTOBuilder withAllowRate(boolean allowRate) {
        this.allowRate = allowRate;
        return this;
    }

    public ImageDTOBuilder withAllowRateIcons(boolean allowRateIcons) {
        this.allowRateIcons = allowRateIcons;
        return this;
    }

    public ImageDTOBuilder withCreated(Timestamp created) {
        this.created = created;
        return this;
    }

    public ImageDTOBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public ImageDTOBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ImageDTOBuilder withIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }
    public ImageDTOBuilder withModified(Date modified) {
        this.modified = modified;
        return this;
    }

    public ImageDTOBuilder but() {
        return anImageDTO().withId(id).withThumb(thumb).withMiddle(middle).withOrig(orig).withRate(rate).withAllowRate(allowRate).withAllowRateIcons(allowRateIcons).withCreated(created).withLabel(label).withDescription(description).withIsActive(isActive).withModified(modified);
    }

    public ImageDTO build() {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setId(id);
        imageDTO.setThumb(thumb);
        imageDTO.setMiddle(middle);
        imageDTO.setOrig(orig);
        imageDTO.setRate(rate);
        imageDTO.setAllowRate(allowRate);
        imageDTO.setAllowRateIcons(allowRateIcons);
        imageDTO.setCreated(created);
        imageDTO.setLabel(label);
        imageDTO.setDescription(description);
        imageDTO.setIsActive(isActive);
        imageDTO.setModifed(modified);
        return imageDTO;
    }
}
