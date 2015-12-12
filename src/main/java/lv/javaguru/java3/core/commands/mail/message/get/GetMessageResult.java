package lv.javaguru.java3.core.commands.mail.message.get;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.mail.message.MessageDTO;

/**
 * Created by Andrew on 01.12.2015.
 */
public class GetMessageResult implements DomainCommandResult{

    private MessageDTO messageDTO;

    public GetMessageResult(MessageDTO messageDTO) {
        this.messageDTO = messageDTO;
    }

    public MessageDTO getMessageDTO() {
        return messageDTO;
    }

}
