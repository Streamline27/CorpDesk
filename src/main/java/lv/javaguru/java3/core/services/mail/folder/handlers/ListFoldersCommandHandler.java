package lv.javaguru.java3.core.services.mail.folder.handlers;

import lv.javaguru.java3.core.commands.mail.folder.FolderConverter;
import lv.javaguru.java3.core.commands.mail.folder.ListFoldersCommand;
import lv.javaguru.java3.core.commands.mail.folder.ListFoldersResult;
import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.dto.mail.folder.FolderDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.folder.FolderService;
import lv.javaguru.java3.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;

/**
 * Created by Andrew on 02.12.2015.
 */
@Component
public class ListFoldersCommandHandler implements DomainCommandHandler<ListFoldersCommand, ListFoldersResult>{

    @Autowired private FolderService folderService;
    @Autowired private UserService userService;
    @Autowired private FolderConverter converter;

    @Override
    public ListFoldersResult execute(ListFoldersCommand command) throws Exception {

        List<FolderDTO> folderDTOList = new ArrayList<>();

        for (Folder folder : folderService.list(userService.get(command.getUserLogin())))
            folderDTOList.add(converter.convert(folder));

        return new ListFoldersResult(folderDTOList);
    }

    @Override
    public Class getCommandType() {
        return ListFoldersCommand.class;
    }
}
