package lv.javaguru.java3.core.commands.mail.folder;

import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.folder.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 02.12.2015.
 */
@Component
public class GetFolderCommandHandler implements DomainCommandHandler<GetFolderCommand, GetFolderResult>{

    @Autowired private FolderService folderService;
    @Autowired private FolderConverter converter;

    @Override
    public GetFolderResult execute(GetFolderCommand command) throws Exception {
        return new GetFolderResult(converter.convert(folderService.get(command.getFolderId())));
    }

    @Override
    public Class getCommandType() {
        return GetFolderCommand.class;
    }
}
