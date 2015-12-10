package lv.javaguru.java3.core.domain.gallerycluster.gallery;

import lv.javaguru.java3.core.domain.gallerycluster.GalleryModifer;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.11.03..
 */
//@Embeddable
@Entity
@Table(name = "galleries")
public class Gallery extends GalleryModifer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint")
    private long id;

    @Column(name = "allow_rate")
    private boolean allowRate;

    @Column(name = "allow_rate_icons")
    private boolean allowRateIcons;


    @OneToMany(cascade=CascadeType.ALL, mappedBy = "gallery")
    private List<Category> categories;

   // @OneToMany(cascade=CascadeType.ALL, mappedBy = "gallery")
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
