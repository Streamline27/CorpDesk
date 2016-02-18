package lv.javaguru.java3.core.dto.gallerycluster;

/**
 * Created by Aleksej_home on 2016.02.16..
 */
public class CategoryPageDTO extends GalleryModiferDTO{
    private Long id;
    private Boolean allowRate;
    private Boolean allowRateIcons;

    private Long imageId;
    private Long imgCount;
    private String imageThumb;
    private String imageLabel;
    private String imageDescription;
    private Boolean imageIsActive;

    public Long getImgCount() {
        return imgCount;
    }

    public void setImgCount(Long imgCount) {
        this.imgCount = imgCount;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(String imageThumb) {
        this.imageThumb = imageThumb;
    }

    public String getImageLabel() {
        return imageLabel;
    }

    public void setImageLabel(String imageLabel) {
        this.imageLabel = imageLabel;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public Boolean isImageIsActive() {
        return imageIsActive;
    }

    public void setImageIsActive(Boolean imageIsActive) {
        this.imageIsActive = imageIsActive;
    }

    public void setAllowRate(Boolean allowRate){
        this.allowRate = allowRate;
    }
    public Boolean getAllowRate(){
        return allowRate;
    }
    public void setAllowRateIcons(Boolean allowRateIcons){
        this.allowRateIcons = allowRateIcons;
    }
    public Boolean getAllowRateIcons(){
        return allowRateIcons;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
