package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.commands.VoidResult;

/**
 * Created by Andrew on 01.12.2015.
 */
public class DeleteMessageCommand implements DomainCommand<VoidResult>{

    private long userId;
    private long messageId;

    public DeleteMessageCommand(long userId, long messageId) {
        this.userId = userId;
        this.messageId = messageId;
    }

    public long getUserId() {
        return userId;
    }

    public long getMessageId() {
        return messageId;
    }

}
