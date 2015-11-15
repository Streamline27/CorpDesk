package lv.javaguru.java3.core.domain;

import java.io.Serializable;

public abstract class Generic implements Serializable {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
