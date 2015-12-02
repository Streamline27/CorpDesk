package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.mail.message.MessageCountDTO;

/**
 * Created by Andrew on 02.12.2015.
 */
public class GetMessageCountResult implements DomainCommandResult {

    private MessageCountDTO messageCountDTO;

    public GetMessageCountResult(MessageCountDTO messageCountDTO) {
        this.messageCountDTO = messageCountDTO;
    }

    public MessageCountDTO getMessageCountDTO() {
        return messageCountDTO;
    }

}
