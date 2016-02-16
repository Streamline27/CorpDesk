package lv.javaguru.java3.core.commands.mail.folder;

import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.FolderType;
import lv.javaguru.java3.core.dto.mail.folder.FolderDTO;
import lv.javaguru.java3.core.services.mail.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.dto.mail.folder.FolderDTOBuilder.createFolderDTO;

/**
 * Created by Andrew on 02.12.2015.
 */
@Component
public class FolderConverter {

    @Autowired MessageService messageService;

    public FolderDTO convert(Folder folder) throws Exception {
        return createFolderDTO()
                .withId(folder.getId())
                .withName(folder.getName())
                .withUserId(folder.getUserId())
                .isRemovable(folder.getFolderType() == FolderType.USER_CREATED)
                .withMessagesCount(messageService.getMessagesCount(folder))
                .withUnreadMessagesCount(messageService.getUnreadMessageCount(folder))
                .build();
    }

}
