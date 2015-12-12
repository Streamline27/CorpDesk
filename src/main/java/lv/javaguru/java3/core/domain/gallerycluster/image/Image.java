package lv.javaguru.java3.core.domain.gallerycluster.image;

import lv.javaguru.java3.core.domain.gallerycluster.GalleryModifer;
import lv.javaguru.java3.core.domain.gallerycluster.category.Category;
import lv.javaguru.java3.core.domain.gallerycluster.reward.Reward;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Aleksej_home on 2015.11.03..
 */
@Entity
@Table(name = "images")
public class Image extends GalleryModifer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint")
    private long id;

    @Column(name = "thumb")
    private String thumb;

   // @Column(name = "cat_id")
  //  private long categoryId;

    @Column(name = "middle")
    private String middle;

    @Column(name = "orig")
    private String orig;

    @Column(name = "rate")
    private int rate;

    @Column(name = "allow_rate")
    private boolean allowRate;

    @Column(name = "allow_rate_icons")
    private boolean allowRateIcons;

    @Column(name = "created")
    private Timestamp created;

    @Column(name = "modified")
    private Date modified;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category category;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "images")
    private List<Reward> rewards = new ArrayList<>();

  //  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "images")
  //  private Set<Reward> rewards;


  /*  public Set<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(Set<Reward> rewards) {
        this.rewards = rewards;
    }

   */
  //@ManyToMany(fetch = FetchType.LAZY, mappedBy = "images")
  public List<Reward> getRewards() {
      return rewards;
  }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public void addReward(Reward reward) {
        if (rewards != null) {
            this.rewards.add(reward);
        }else {
            this.rewards = new ArrayList<>();
            this.rewards.add(reward);
        }
    }

   // @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /*public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Date getModifed() {
        return modified;
    }

    public void setModifed(Date modifed) {
        this.modified = modifed;
    }
}
