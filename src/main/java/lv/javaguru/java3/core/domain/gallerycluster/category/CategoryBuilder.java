package lv.javaguru.java3.core.domain.gallerycluster.category;

import lv.javaguru.java3.core.domain.gallerycluster.gallery.Gallery;

import java.sql.Date;

/**
 * Created by Aleksej_home on 2015.11.09..
 */
public class CategoryBuilder {
    private String label;
    private String description;
    private boolean isActive;
    private long id;
   // private long galleryId;
   // private long imgId;
    private boolean allowRate;
    private boolean allowRateIcons;
    private Date modified;
    private Gallery gallery;

    private CategoryBuilder() {
    }

    public static CategoryBuilder aCategory() {
        return new CategoryBuilder();
    }

    public CategoryBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public CategoryBuilder withGallery(Gallery gallery) {
        this.gallery = gallery;
        return this;
    }
  /*  public CategoryBuilder withGalleryId(long galleryId) {
        this.galleryId = galleryId;
        return this;
    }*/

    public CategoryBuilder withModified(Date modified) {
        this.modified = modified;
        return this;
    }

   /* public CategoryBuilder withImgId(long imgId) {
        this.imgId = imgId;
        return this;
    }*/

    public CategoryBuilder withAllowRate(boolean allowRate) {
        this.allowRate = allowRate;
        return this;
    }

    public CategoryBuilder withAllowRateIcons(boolean allowRateIcons) {
        this.allowRateIcons = allowRateIcons;
        return this;
    }

    public CategoryBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public CategoryBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryBuilder withIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public CategoryBuilder but() {
        return aCategory()
             //   .withId(id)
              //  .withGalleryId(galleryId)
              //  .withImgId(imgId)
                .withAllowRate(allowRate)
                .withAllowRateIcons(allowRateIcons)
                .withLabel(label)
                .withDescription(description)
                .withIsActive(isActive)
                .withModified(modified);
    }

    public Category build() {
        Category category = new Category();
        category.setId(id);
      //  category.setGalleryId(galleryId);
      //  category.setImgId(imgId);
        category.setAllowRate(allowRate);
        category.setAllowRateIcons(allowRateIcons);
        category.setLabel(label);
        category.setDescription(description);
        category.setIsActive(isActive);
        category.setModifed(modified);
        category.setGallery(gallery);
        return category;
    }
}
