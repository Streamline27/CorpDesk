package lv.javaguru.java3.core.domain.mail;

import lv.javaguru.java3.core.domain.Generic;
import lv.javaguru.java3.core.domain.user.User;

import javax.persistence.*;

/**
 * Created by Andrew on 08.11.2015.
 */
@Entity
@Table(name = "message_folders")
public class Folder extends Generic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private FolderCategory category;

    public Folder() {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FolderCategory getCategory() {
        return category;
    }

    public void setCategory(FolderCategory category) {
        this.category = category;
    }
}
