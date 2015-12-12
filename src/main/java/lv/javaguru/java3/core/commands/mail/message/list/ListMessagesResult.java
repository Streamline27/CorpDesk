package lv.javaguru.java3.core.commands.mail.message.list;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.mail.message.MessageHeaderDTO;

import java.util.List;

/**
 * Created by Andrew on 01.12.2015.
 */
public class ListMessagesResult implements DomainCommandResult {

    private List<MessageHeaderDTO> messageHeaderDTOs;

    public ListMessagesResult(List<MessageHeaderDTO> messageHeaderDTOs) {
        this.messageHeaderDTOs = messageHeaderDTOs;
    }

    public List<MessageHeaderDTO> getMessageHeadersDTO() {
        return messageHeaderDTOs;
    }

}
