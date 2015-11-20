package lv.javaguru.java3.core.services.mail.folder;

import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.FolderCategory;
import lv.javaguru.java3.core.domain.user.User;

/**
 * Created by Andrew on 17.11.2015.
 */
public interface FolderService {

    Folder get(User user, FolderCategory category);

}
