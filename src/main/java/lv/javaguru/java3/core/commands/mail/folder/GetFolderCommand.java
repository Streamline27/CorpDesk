package lv.javaguru.java3.core.commands.mail.folder;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by Andrew on 02.12.2015.
 */
public class GetFolderCommand implements DomainCommand<GetFolderResult>{

    private long folderId;

    public GetFolderCommand(long folderId) {
        this.folderId = folderId;
    }

    public long getFolderId() {
        return folderId;
    }

}
