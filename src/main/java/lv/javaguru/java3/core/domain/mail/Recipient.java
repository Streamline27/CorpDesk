package lv.javaguru.java3.core.domain.mail;

import lv.javaguru.java3.core.domain.Generic;
import lv.javaguru.java3.core.domain.user.User;

import javax.persistence.*;

/**
 * Created by Andrew on 08.11.2015.
 */
@Entity
@Table(name = "messages_users")
public class Recipient extends Generic{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "folder_id")
    private Folder folder;

    @Column(name = "is_unread")
    private boolean isUnread;

    @Column(name = "is_active")
    private boolean isActive;

    public Recipient() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public boolean isUnread() {
        return isUnread;
    }

    public void setIsUnread(boolean isUnread) {
        this.isUnread = isUnread;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
