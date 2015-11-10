package lv.javaguru.java3.core.domain.gallery_cluster.category;

import lv.javaguru.java3.core.domain.gallery_cluster.GalleryModifer;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Aleksej_home on 2015.11.03..
 */
@Entity
@Table(name = "categories")
public class Category extends GalleryModifer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint")
    private long id;

    @Column(name = "gallery_id")
    private long galleryId;

    @Column(name = "img_id")
    private long imgId;

    @Column(name = "allow_rate")
    private boolean allowRate;

    @Column(name = "allow_rate_icons")
    private boolean allowRateIcons;

    @Column(name = "created")
    private Timestamp created;

    @Column(name = "modified")
    private Date modified;


    public long getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(long galleryId) {
        this.galleryId = galleryId;
    }

    public long getImgId() {
        return imgId;
    }

    public void setImgId(long imgId) {
        this.imgId = imgId;
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

    public Date getModifed() {
        return modified;
    }

    public void setModifed(Date modifed) {
        this.modified = modifed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
