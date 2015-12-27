package lv.javaguru.java3.core.commands.mail.folder;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.mail.folder.FolderDTO;

/**
 * Created by Andrew on 02.12.2015.
 */
public class GetFolderResult implements DomainCommandResult{

    private final FolderDTO folderDTO;

    public GetFolderResult(FolderDTO folderDTO) {
        this.folderDTO = folderDTO;
    }

    public FolderDTO getFolderDTO() {
        return folderDTO;
    }

}
