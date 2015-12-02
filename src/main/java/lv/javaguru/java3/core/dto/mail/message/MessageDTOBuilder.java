package lv.javaguru.java3.core.dto.mail.message;

import lv.javaguru.java3.core.domain.user.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Andrew on 01.12.2015.
 */
public class MessageDTOBuilder {

    private Long id;
    private User sender;
    private String title;
    private String body;
    private boolean isImportant;
    private Date created;
    private List<User> recipients;

    public MessageDTOBuilder() {
    }

    public static MessageDTOBuilder createMessageDTO() {
        return new MessageDTOBuilder();
    }

    public MessageDTO build() {
        MessageDTO dto = new MessageDTO();
        dto.setId(id);
        dto.setSender(sender);
        dto.setTitle(title);
        dto.setBody(body);
        dto.setIsImportant(isImportant);
        dto.setCreated(created);
        dto.setRecipients(recipients);
        return dto;
    }

    public MessageDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public MessageDTOBuilder withSender(User sender) {
        this.sender = sender;
        return this;
    }

    public MessageDTOBuilder withTitle(String  title) {
        this.title = title;
        return this;
    }

    public MessageDTOBuilder withBody(String  body) {
        this.body = body;
        return this;
    }

    public MessageDTOBuilder isImportant(boolean isImportant) {
        this.isImportant = isImportant;
        return this;
    }

    public MessageDTOBuilder withCreated(Date created) {
        this.created = created;
        return this;
    }

    public MessageDTOBuilder withRecipients(List<User> recipients) {
        this.recipients = recipients;
        return this;
    }
}
