package lv.javaguru.java3.core.domain.gallery_cluster.image;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class ImageBuilder {
    private String label;
    private String description;
    private boolean isActive;
    private long id;
    private String thumb;
    private String middle;
    private String orig;
    private int rate;
    private boolean allowRate;
    private boolean allowRateIcons;
    private Date modified;
    private Timestamp created;

    private ImageBuilder() {
    }

    public static ImageBuilder anImage() {
        return new ImageBuilder();
    }

    public ImageBuilder withId(long id) {
        this.id = id;
        return this;
    }
    public ImageBuilder withModified(Date modified) {
        this.modified = modified;
        return this;
    }

    public ImageBuilder withThumb(String thumb) {
        this.thumb = thumb;
        return this;
    }

    public ImageBuilder withMiddle(String middle) {
        this.middle = middle;
        return this;
    }

    public ImageBuilder withOrig(String orig) {
        this.orig = orig;
        return this;
    }

    public ImageBuilder withRate(int rate) {
        this.rate = rate;
        return this;
    }

    public ImageBuilder withAllowRate(boolean allowRate) {
        this.allowRate = allowRate;
        return this;
    }

    public ImageBuilder withAllowRateIcons(boolean allowRateIcons) {
        this.allowRateIcons = allowRateIcons;
        return this;
    }

    public ImageBuilder withCreated(Timestamp created) {
        this.created = created;
        return this;
    }

    public ImageBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public ImageBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ImageBuilder withIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public ImageBuilder but() {
        return anImage().withId(id).withThumb(thumb).withMiddle(middle).withOrig(orig).withRate(rate).withAllowRate(allowRate).withAllowRateIcons(allowRateIcons).withCreated(created).withLabel(label).withDescription(description).withIsActive(isActive).withModified(modified);
    }

    public Image build() {
        Image image = new Image();
        image.setId(id);
        image.setThumb(thumb);
        image.setMiddle(middle);
        image.setOrig(orig);
        image.setRate(rate);
        image.setAllowRate(allowRate);
        image.setAllowRateIcons(allowRateIcons);
        image.setCreated(created);
        image.setLabel(label);
        image.setDescription(description);
        image.setIsActive(isActive);
        image.setModifed(modified);
        return image;
    }
}
