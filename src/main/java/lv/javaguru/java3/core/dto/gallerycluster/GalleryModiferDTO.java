package lv.javaguru.java3.core.dto.gallerycluster;

import java.io.Serializable;

/**
 * Created by Aleksej_home on 2015.11.17..
 */
public abstract class GalleryModiferDTO implements Serializable {

    protected String label;
    protected String description;
    protected boolean isActive;
    protected Object addition;

    public Object getAddition() {
        return addition;
    }

    public void setAddition(Object addition) {
        this.addition = addition;
    }

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
