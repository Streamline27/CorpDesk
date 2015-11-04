package lv.javaguru.java3.core.domain.gallery;

import javax.persistence.*;

/**
 * Created by Aleksej_home on 2015.11.03..
 */
@Entity
@Table(name = "rewards")
public class Reward extends GalleryModifer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint")
    private long id;

    @Column(name = "name")
    private String name;

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
