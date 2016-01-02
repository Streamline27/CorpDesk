package lv.javaguru.java3.core.domain.mail;

import java.util.Date;
import java.util.List;

/**
 * Created by Andrew on 08.11.2015.
 */
public class MessageBuilder {
    private long senderId;
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

        message.setSenderId(senderId);
        message.setTitle(title);
        message.setBody(body);
        message.setIsImportant(isImportant);
        message.setIsActive(isActive);
        message.setCreated(created);
        message.setRecipients(recipients);

        return message;

    }

    public MessageBuilder withSenderId(long senderId) {
        this.senderId = senderId;
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
