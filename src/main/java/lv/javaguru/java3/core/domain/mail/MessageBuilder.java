package lv.javaguru.java3.core.domain.mail;

import lv.javaguru.java3.core.domain.user.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Andrew on 08.11.2015.
 */
public class MessageBuilder {
    private User sender;
    private String title;
    private String body;
    private boolean isImportant;
    private boolean isActive;
    private Date created;
    private List<Recipient> recipients;

    public MessageBuilder() {
    }

    public static MessageBuilder createMessage() {
        return new MessageBuilder();
    }

    public Message build() {

        Message message = new Message();

        message.setSender(sender);
        message.setTitle(title);
        message.setBody(body);
        message.setIsImportant(isImportant);
        message.setIsActive(isActive);
        message.setCreated(created);
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

    public MessageBuilder createdOn(Date created) {
        this.created = created;
        return this;
    }

    public MessageBuilder withRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
        return this;
    }

}
