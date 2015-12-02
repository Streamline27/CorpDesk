package lv.javaguru.java3.core.dto.mail.message;

import lv.javaguru.java3.core.domain.user.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrew on 01.12.2015.
 */
public class MessageDTO implements Serializable {

    private Long id;
    private User sender;
    private String title;
    private String body;
    private boolean isImportant;
    private Date created;
    private List<User> recipients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<User> recipients) {
        this.recipients = recipients;
    }
}
