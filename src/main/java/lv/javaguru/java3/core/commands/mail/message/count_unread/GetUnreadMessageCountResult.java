package lv.javaguru.java3.core.commands.mail.message.count_unread;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.mail.message.MessageCountDTO;

/**
 * Created by Andrew on 01.12.2015.
 */
public class GetUnreadMessageCountResult implements DomainCommandResult{

    private final MessageCountDTO messageCountDTO;

    public GetUnreadMessageCountResult(MessageCountDTO messageCountDTO) {
        this.messageCountDTO = messageCountDTO;
    }

    public MessageCountDTO getMessageCountDTO() {
        return messageCountDTO;
    }

}
