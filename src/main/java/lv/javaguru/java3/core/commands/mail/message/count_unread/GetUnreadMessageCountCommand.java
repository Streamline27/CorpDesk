package lv.javaguru.java3.core.commands.mail.message.count_unread;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Andrew on 01.12.2015.
 */
public class GetUnreadMessageCountCommand implements DomainCommand<GetUnreadMessageCountResult>{

    private final long folderId;

    public GetUnreadMessageCountCommand(long folderId) {
        this.folderId = folderId;
    }

    public long getFolderId() {
        return folderId;
    }

}
