package lv.javaguru.java3.core.dto.user;

import java.io.Serializable;
import java.util.Date;

public class GroupDTO implements Serializable {

    private long id;
    private String name;
    private Date lastModified;
    private StateDTO state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public StateDTO getState() {
        return state;
    }

    public void setState(StateDTO state) {
        this.state = state;
    }

}