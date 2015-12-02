package lv.javaguru.java3.core.dto.mail.message;

import lv.javaguru.java3.core.domain.user.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Andrew on 01.12.2015.
 */
public class MessageHeaderDTO implements Serializable {

    private Long messageId;
    private User sender;
    private String title;
    private boolean isImportant;
    private Date created;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
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

}
