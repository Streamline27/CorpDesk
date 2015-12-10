package lv.javaguru.java3.core.dto.gallerycluster;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class GalleryDTO extends GalleryModiferDTO {

    private long userId;
    private boolean allowRate;
    private boolean allowRateIcons;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setAllowRate(boolean allowRate){
        this.allowRate = allowRate;
    }
    public boolean getAllowRate(){
        return allowRate;
    }
    public void setAllowRateIcons(boolean allowRateIcons){
        this.allowRateIcons = allowRateIcons;
    }
    public boolean getAllowRateIcons(){
        return allowRateIcons;
    }

}
