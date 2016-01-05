package lv.javaguru.java3.core.domain.mail;

import lv.javaguru.java3.core.domain.Generic;
import lv.javaguru.java3.core.domain.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrew on 08.11.2015.
 */
@Entity
@Table(name = "messages")
public class Message extends Generic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private long id;

    @Column(name = "sender_id")
    private long senderId;

    @Column(name = "title")
    private String title;

    @Column(name = "body", columnDefinition = "clob")
    private String body;

    @Column(name = "is_important")
    private boolean isImportant;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created", nullable = false)
    private Date created;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    private List<Recipient> recipients;

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setIsImportant(boolean isImportant) {
        this.isImportant = isImportant;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Recipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }
}
