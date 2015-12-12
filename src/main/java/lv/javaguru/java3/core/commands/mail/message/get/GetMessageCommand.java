package lv.javaguru.java3.core.commands.mail.message.get;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.commands.DomainCommandResult;

/**
 * Created by Andrew on 01.12.2015.
 */
public class GetMessageCommand implements DomainCommand<GetMessageResult> {

    private long messageId;

    public GetMessageCommand(long messageId) {
        this.messageId = messageId;
    }

    public long getMessageId() {
        return messageId;
    }

}
