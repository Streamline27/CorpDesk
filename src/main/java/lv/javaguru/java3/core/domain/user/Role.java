package lv.javaguru.java3.core.domain.user;


import lv.javaguru.java3.core.domain.Generic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends Generic {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Override
    public long getId() {
        return id;
    }

    @Override
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
