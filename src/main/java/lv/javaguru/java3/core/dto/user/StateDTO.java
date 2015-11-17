package lv.javaguru.java3.core.dto.user;

import java.io.Serializable;

public class StateDTO implements Serializable {

    private long id;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
