package lv.javaguru.java3.core.database.mail;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.mail.FolderCategory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.transaction.Transactional;

import java.util.List;

import static lv.javaguru.java3.core.domain.mail.FolderCategoryBuilder.createFolderCategory;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Andrew on 15.11.2015.
 */
public class FolderCategoryDAOImplTest extends DatabaseHibernateTest{

    @Test
    @Transactional
    public void testGetAll() {

        List<FolderCategory> list = folderCategoryDAO.getAll();

        assertEquals(5, list.size());

    }

    @Test
    @Transactional
    public void testAll5Categories() {

        FolderCategory catInbox = createFolderCategory().inbox().build();
        FolderCategory catSent = createFolderCategory().sent().build();
        FolderCategory catDraft = createFolderCategory().draft().build();
        FolderCategory catDeleted = createFolderCategory().deleted().build();
        FolderCategory catCustom = createFolderCategory().custom().build();

        assertTrue(catInbox.getName().equals(folderCategoryDAO.getById(catInbox.getId()).getName()));
        assertTrue(catSent.getName().equals(folderCategoryDAO.getById(catSent.getId()).getName()));
        assertTrue(catDraft.getName().equals(folderCategoryDAO.getById(catDraft.getId()).getName()));
        assertTrue(catDeleted.getName().equals(folderCategoryDAO.getById(catDeleted.getId()).getName()));
        assertTrue(catCustom.getName().equals(folderCategoryDAO.getById(catCustom.getId()).getName()));
    }

}
