package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.commands.VoidResult;

/**
 * Created by Andrew on 01.12.2015.
 */
public class MoveToFolderCommand implements DomainCommand<VoidResult>{

    private long messageId;
    private long userId;
    private long newFolderId;

    public MoveToFolderCommand(long messageId, long userId, long newFolderId) {
        this.messageId = messageId;
        this.userId = userId;
        this.newFolderId = newFolderId;
    }

    public long getMessageId() {
        return messageId;
    }

    public long getUserId() {
        return userId;
    }

    public long getNewFolderId() {
        return newFolderId;
    }
}
