package lv.javaguru.java3.core.commands.mail.folder;

import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.folder.FolderService;
import org.springframework.beans.factory.annotation.Autowired;

import static lv.javaguru.java3.core.domain.mail.FolderBuilder.createFolder;

/**
 * Created by Andrew on 02.12.2015.
 */
public class DeleteFolderCommandHandler implements DomainCommandHandler<DeleteFolderCommand, VoidResult>{

    @Autowired private FolderService folderService;

    @Override
    public VoidResult execute(DeleteFolderCommand command) throws Exception {

        folderService.delete(createFolder().withId(command.getFolderId()).build());

        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return DeleteFolderCommand.class;
    }
}
