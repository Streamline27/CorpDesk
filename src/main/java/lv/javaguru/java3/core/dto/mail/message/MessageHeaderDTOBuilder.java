package lv.javaguru.java3.core.dto.mail.message;

import lv.javaguru.java3.core.domain.user.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Andrew on 01.12.2015.
 */
public class MessageHeaderDTOBuilder {


    private Long messageId;
    private User sender;
    private String title;
    private String body;
    private boolean isImportant;
    private Date created;
    private List<User> recipients;

    public MessageHeaderDTOBuilder() {
    }

    public static MessageHeaderDTOBuilder createMessageHeaderDTO() {
        return new MessageHeaderDTOBuilder();
    }

    public MessageHeaderDTO build() {
        MessageHeaderDTO dto = new MessageHeaderDTO();
        dto.setMessageId(messageId);
        dto.setSender(sender);
        dto.setTitle(title);
        dto.setIsImportant(isImportant);
        dto.setCreated(created);
        return dto;
    }

    public MessageHeaderDTOBuilder withMessageId(Long messageId) {
        this.messageId = messageId;
        return this;
    }

    public MessageHeaderDTOBuilder withSender(User sender) {
        this.sender = sender;
        return this;
    }

    public MessageHeaderDTOBuilder withTitle(String  title) {
        this.title = title;
        return this;
    }

    public MessageHeaderDTOBuilder isImportant(boolean isImportant) {
        this.isImportant = isImportant;
        return this;
    }

    public MessageHeaderDTOBuilder withCreated(Date created) {
        this.created = created;
        return this;
    }

}
