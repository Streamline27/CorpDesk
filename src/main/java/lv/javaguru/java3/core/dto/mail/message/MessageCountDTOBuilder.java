package lv.javaguru.java3.core.dto.mail.message;

/**
 * Created by Andrew on 01.12.2015.
 */
public class MessageCountDTOBuilder {

    private int messageCount;

    public MessageCountDTOBuilder() {
    }

    public static MessageCountDTOBuilder createMessageCountDTO() {
        return new MessageCountDTOBuilder();
    }

    public MessageCountDTO build() {
        MessageCountDTO dto = new MessageCountDTO();
        dto.setMessageCount(messageCount);
        return dto;
    }

    public MessageCountDTOBuilder withMessageCount(int messageCount) {
        this.messageCount = messageCount;
        return this;
    }

}
