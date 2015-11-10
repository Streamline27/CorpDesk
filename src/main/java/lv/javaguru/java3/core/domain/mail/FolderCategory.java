package lv.javaguru.java3.core.domain.mail;

import lv.javaguru.java3.core.domain.Generic;

import javax.persistence.*;

/**
 * Created by Andrew on 08.11.2015.
 */
@Entity
@Table(name = "message_folder_categories")
public class FolderCategory extends Generic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public FolderCategory() {
    }

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
