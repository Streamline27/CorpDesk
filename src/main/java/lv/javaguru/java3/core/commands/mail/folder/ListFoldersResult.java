package lv.javaguru.java3.core.commands.mail.folder;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.mail.folder.FolderDTO;

import java.util.List;

/**
 * Created by Andrew on 02.12.2015.
 */
public class ListFoldersResult implements DomainCommandResult {

    private final List<FolderDTO> folderDTOList;

    public ListFoldersResult(List<FolderDTO> folderDTOList) {
        this.folderDTOList = folderDTOList;
    }

    public List<FolderDTO> getFolderDTOList() {
        return folderDTOList;
    }

}
