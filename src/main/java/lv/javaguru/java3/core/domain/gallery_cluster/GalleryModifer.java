package lv.javaguru.java3.core.domain.gallery_cluster;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Aleksej_home on 2015.11.03..
 */

@MappedSuperclass
public abstract class GalleryModifer implements Serializable{


    @Column(name = "label")
    protected String label;

    @Column(name = "description", columnDefinition = "clob")
    protected String description;

    @Column(name = "is_active")
    protected boolean isActive;



    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
