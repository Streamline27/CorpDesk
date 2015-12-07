package lv.javaguru.java3.core.commands.mail.folder;

import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.dto.mail.folder.FolderDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.domain.mail.FolderCategoryBuilder.createFolderCategory;
import static lv.javaguru.java3.core.dto.mail.folder.FolderDTOBuilder.createFolderDTO;

/**
 * Created by Andrew on 02.12.2015.
 */
@Component
public class FolderConverter {

    public FolderDTO convert(Folder folder) {
        return createFolderDTO()
                .withId(folder.getId())
                .withName(folder.getName())
                .withUserId(folder.getUserId())
                .isRemovable(folder.getCategory() == createFolderCategory().custom().build())
                .build();
    }

}
