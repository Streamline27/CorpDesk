package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Andrew on 01.12.2015.
 */
public class GetUnreadMessageCountCommand implements DomainCommand<GetUnreadMessageCountResult>{

    private long folderId;

    public GetUnreadMessageCountCommand(long folderId) {
        this.folderId = folderId;
    }

    public long getFolderId() {
        return folderId;
    }

}
