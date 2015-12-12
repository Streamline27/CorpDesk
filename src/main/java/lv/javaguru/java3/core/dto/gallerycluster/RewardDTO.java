package lv.javaguru.java3.core.dto.gallerycluster;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public class RewardDTO extends GalleryModiferDTO {

    private long id;
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
