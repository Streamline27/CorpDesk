package lv.javaguru.java3.core.commands.mail.message.count;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Andrew on 02.12.2015.
 */
public class GetMessageCountCommand implements DomainCommand<GetMessageCountResult> {

    private final long folderId;

    public GetMessageCountCommand(long folderId) {
        this.folderId = folderId;
    }

    public long getFolderId() {
        return folderId;
    }

}
