package lv.javaguru.java3.core.services.mail.folder.handlers;

import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.commands.mail.folder.DeleteFolderCommand;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.folder.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.domain.mail.FolderBuilder.createFolder;

/**
 * Created by Andrew on 02.12.2015.
 */
@Component
public class DeleteFolderCommandHandler implements DomainCommandHandler<DeleteFolderCommand, VoidResult>{

    @Autowired private FolderService folderService;

    @Override
    public VoidResult execute(DeleteFolderCommand command) throws Exception {

        folderService.delete(folderService.get(command.getFolderId()));

        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return DeleteFolderCommand.class;
    }
}
