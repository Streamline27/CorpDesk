package lv.javaguru.java3.core.domain.gallerycluster.gallery;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class GalleryBuilder {
    private String label;
    private String description;
    private boolean isActive;
    private long id;
    private boolean allowRate;
    private boolean allowRateIcons;

    private GalleryBuilder() {
    }

    public static GalleryBuilder aGallery() {
        return new GalleryBuilder();
    }

    public GalleryBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public GalleryBuilder withAllowRate(boolean allowRate) {
        this.allowRate = allowRate;
        return this;
    }

    public GalleryBuilder withAllowRateIcons(boolean allowRateIcons) {
        this.allowRateIcons = allowRateIcons;
        return this;
    }

    public GalleryBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public GalleryBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public GalleryBuilder withIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public GalleryBuilder but() {
        return aGallery()
                //.withUserId(userId)
                .withAllowRate(allowRate)
                .withAllowRateIcons(allowRateIcons)
                .withLabel(label)
                .withDescription(description)
                .withIsActive(isActive);
    }

    public Gallery build() {
        Gallery gallery = new Gallery();
        gallery.setId(id);
        gallery.setAllowRate(allowRate);
        gallery.setAllowRateIcons(allowRateIcons);
        gallery.setLabel(label);
        gallery.setDescription(description);
        gallery.setIsActive(isActive);
        return gallery;
    }
}
