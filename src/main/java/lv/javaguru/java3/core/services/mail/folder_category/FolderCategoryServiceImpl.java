package lv.javaguru.java3.core.services.mail.folder_category;

import lv.javaguru.java3.core.database.mail.FolderCategoryDAO;
import lv.javaguru.java3.core.domain.mail.FolderCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static lv.javaguru.java3.core.domain.mail.FolderCategoryBuilder.createFolderCategory;

/**
 * Created by Andrew on 21.11.2015.
 */
@Component
public class FolderCategoryServiceImpl implements FolderCategoryService {

    @Autowired private FolderCategoryDAO dao;

    @Override
    public List<FolderCategory> list() {
        return dao.getAll();
    }

    @Override
    public FolderCategory getInbox() { return createFolderCategory().inbox().build(); }

    @Override
    public FolderCategory getSent() {
        return createFolderCategory().sent().build();
    }

    @Override
    public FolderCategory getDraft() {
        return createFolderCategory().draft().build();
    }

    @Override
    public FolderCategory getDeleted() {
        return createFolderCategory().deleted().build();
    }

    @Override
    public FolderCategory getCustom() {
        return createFolderCategory().custom().build();
    }

}
