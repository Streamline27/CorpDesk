package lv.javaguru.java3.core.domain.gallerycluster.reward;

import lv.javaguru.java3.core.domain.gallerycluster.GalleryModifer;
import lv.javaguru.java3.core.domain.gallerycluster.image.Image;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksej_home on 2015.11.03..
 */
@Entity
@Table(name = "rewards")
public class Reward extends GalleryModifer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "rewards_images", joinColumns = @JoinColumn(name = "reward_id",
            referencedColumnName = "id",
            columnDefinition = "bigint"),
            inverseJoinColumns = @JoinColumn(name = "image_id",
                    referencedColumnName = "id", columnDefinition = "bigint"))
    private List<Image> images;

  //  private Set<Image> images2;


   /* public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }*/
  /* @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinTable(name = "rewards_images", joinColumns = @JoinColumn(name = "reward_id",
           referencedColumnName = "id",
           columnDefinition = "bigint"),
           inverseJoinColumns = @JoinColumn(name = "image_id",
                   referencedColumnName = "id", columnDefinition = "bigint"))*/
   public List<Image> getImages() {
       return images;
   }

    public void addImage(Image image) {
        if (images != null) {
            this.images.add(image);
        }else {
            this.images = new ArrayList<>();
            this.images.add(image);
        }
    }


    public void setImages(List<Image> images) {
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
