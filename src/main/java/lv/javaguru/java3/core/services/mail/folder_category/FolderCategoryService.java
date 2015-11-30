package lv.javaguru.java3.core.services.mail.folder_category;

import lv.javaguru.java3.core.domain.mail.FolderCategory;

import java.util.List;

/**
 * Created by Andrew on 21.11.2015.
 */
public interface FolderCategoryService {

    List<FolderCategory> list();

    FolderCategory getInbox();

    FolderCategory getSent();

    FolderCategory getDraft();

    FolderCategory getDeleted();

    FolderCategory getCustom();

}
