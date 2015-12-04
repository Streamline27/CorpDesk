package lv.javaguru.java3.core.commands.mail.folder;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.commands.VoidResult;

/**
 * Created by Andrew on 02.12.2015.
 */
public class DeleteFolderCommand implements DomainCommand<VoidResult> {

    private long folderId;

    public DeleteFolderCommand(long folderId) {
        this.folderId = folderId;
    }

    public long getFolderId() {
        return folderId;
    }

}
