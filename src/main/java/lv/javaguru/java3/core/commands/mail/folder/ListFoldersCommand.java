package lv.javaguru.java3.core.commands.mail.folder;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Andrew on 02.12.2015.
 */
public class ListFoldersCommand implements DomainCommand<ListFoldersResult>{

    private final long userId;

    public ListFoldersCommand(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

}
