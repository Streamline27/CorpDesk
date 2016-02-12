package lv.javaguru.java3.core.services.mail.folder.handlers;

import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.commands.mail.folder.CreateFolderCommand;
import lv.javaguru.java3.core.domain.mail.FolderType;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.folder.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.domain.mail.FolderBuilder.createFolder;

/**
 * Created by Andrew on 02.12.2015.
 */
@Component
public class CreateFolderCommandHandler implements DomainCommandHandler<CreateFolderCommand, VoidResult>{

    @Autowired private FolderService folderService;

    @Override
    public VoidResult execute(CreateFolderCommand command) throws Exception {

        folderService.create(
                createFolder()
                        .withName(command.getFolderDTO().getName())
                        .withType(FolderType.USER_CREATED)
                        .withUserId(command.getFolderDTO().getUserId())
                        .build()
        );

        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return CreateFolderCommand.class;
    }
}
