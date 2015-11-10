package lv.javaguru.java3.core.domain.gallery_cluster.gallery;

import lv.javaguru.java3.core.domain.gallery_cluster.GalleryModifer;

import javax.persistence.*;

/**
 * Created by Aleksej_home on 2015.11.03..
 */
//@Embeddable
@Entity
@Table(name = "galleries")
public class Gallery extends GalleryModifer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", columnDefinition = "bigint")
    private long userId;

    @Column(name = "allow_rate")
    private boolean allowRate;

    @Column(name = "allow_rate_icons")
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
