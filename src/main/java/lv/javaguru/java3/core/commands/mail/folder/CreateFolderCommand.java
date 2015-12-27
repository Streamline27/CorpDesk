package lv.javaguru.java3.core.commands.mail.folder;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.dto.mail.folder.FolderDTO;

/**
 * Created by Andrew on 02.12.2015.
 */
public class CreateFolderCommand implements DomainCommand<VoidResult>{

    private final FolderDTO folderDTO;

    public CreateFolderCommand(FolderDTO folderDTO) {
        this.folderDTO = folderDTO;
    }

    public FolderDTO getFolderDTO() {
        return folderDTO;
    }

}
