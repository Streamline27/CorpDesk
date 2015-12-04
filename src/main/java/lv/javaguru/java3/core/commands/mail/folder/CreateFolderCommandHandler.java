package lv.javaguru.java3.core.commands.mail.folder;

import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.folder.FolderService;
import org.springframework.beans.factory.annotation.Autowired;

import static lv.javaguru.java3.core.domain.mail.FolderBuilder.createFolder;
import static lv.javaguru.java3.core.domain.mail.FolderCategoryBuilder.createFolderCategory;

/**
 * Created by Andrew on 02.12.2015.
 */
public class CreateFolderCommandHandler implements DomainCommandHandler<CreateFolderCommand, VoidResult>{

    @Autowired private FolderService folderService;

    @Override
    public VoidResult execute(CreateFolderCommand command) throws Exception {

        folderService.create(
                createFolder()
                        .withName(command.getFolderDTO().getName())
                        .withCategory(
                                createFolderCategory()
                                        .custom()
                                        .build())
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
