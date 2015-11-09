package lv.javaguru.java3.core.domain.mail;

import lv.javaguru.java3.core.domain.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 08.11.2015.
 */
public class MessageBuilder {
    private long id;
    private User sender;
    private String title;
    private String body;
    private boolean isImportant;
    private boolean isActive;
    private Timestamp created;
    private Timestamp modified;
    private List<Recipient> recipients = new ArrayList<>();

    public MessageBuilder() {
    }

    public static MessageBuilder createMessage() {
        return new MessageBuilder();
    }

    public Message build() {

        Message message = new Message();

        message.setId(id);
        message.setSender(sender);
        message.setTitle(title);
        message.setBody(body);
        message.setIsImportant(isImportant);
        message.setIsActive(isActive);
        message.setCreated(created);
        message.setModified(modified);
        message.setRecipients(recipients);

        return message;

    }

    public MessageBuilder withSender(User sender) {
        this.sender = sender;
        return this;
    }

    public MessageBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public MessageBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public MessageBuilder isImportant(boolean isImportant) {
        this.isImportant = isImportant;
        return this;
    }

    public MessageBuilder isActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public MessageBuilder createdOn(Timestamp created) {
        this.created = created;
        return this;
    }

    public MessageBuilder modifiedOn(Timestamp modified) {
        this.modified = modified;
        return this;
    }

    public MessageBuilder withRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
        return this;
    }

}
