package lv.javaguru.java3.core.commands.mail.message.list;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Andrew on 01.12.2015.
 */
public class ListMessagesCommand implements DomainCommand<ListMessagesResult>{

    private final long folderId;

    public ListMessagesCommand(long folderId) {
        this.folderId = folderId;
    }

    public long getFolderId() {
        return folderId;
    }

}
