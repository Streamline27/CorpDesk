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

    private FolderCategory category1;
    private FolderCategory category2;

    @Before
    public void init() {
        category1 = createFolderCategory().withName("TestCat1").build();
        category2 = createFolderCategory().withName("TestCat2").build();
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

    @Test
    @Transactional
    public void testCreateFolderCategory() {
        assertEquals(0, category1.getId());
        folderCategoryDAO.create(category1);

        assertTrue(category1.getId() > 0);

        assertThat(category1.getId(), is(notNullValue()));
        assertThat(category1.getName(), is(notNullValue()));

        FolderCategory groupFromDB = folderCategoryDAO.getById(category1.getId());
        assertEquals(category1.getName(), groupFromDB.getName());
    }

    @Test
    @Transactional
    public void testGetById() {
        folderCategoryDAO.create(category1);
        FolderCategory catFromDb = folderCategoryDAO.getById(category1.getId());
        assertThat(catFromDb, is(notNullValue()));
    }

    @Test
    @Transactional
    public void testMultipleCatCreation() {
        List<FolderCategory> cats = folderCategoryDAO.getAll();
        int catsCount = cats == null ? 0 : cats.size();

        folderCategoryDAO.create(category1);
        folderCategoryDAO.create(category2);
        cats = folderCategoryDAO.getAll();
        assertEquals(2, cats.size() - catsCount);
    }

    @Test
    @Transactional
    @Ignore
    public void testDelete()  {
        List<FolderCategory> cats = folderCategoryDAO.getAll();
        int catsCount = cats == null ? 0 : cats.size();

        folderCategoryDAO.create(category1);
        folderCategoryDAO.create(category2);
        cats = folderCategoryDAO.getAll();
        assertEquals(2, cats.size() - catsCount);

        folderCategoryDAO.delete(category1);
        cats = folderCategoryDAO.getAll();
        assertEquals(1, cats.size() - catsCount); // Fails to delete

        folderCategoryDAO.delete(category2);
        cats = folderCategoryDAO.getAll();
        assertEquals(0, cats.size() - catsCount);
    }

    @Test
    @Transactional
    public void testUpdate()  {
        folderCategoryDAO.create(category1);

        category1 = folderCategoryDAO.getById(category1.getId());

        category1.setName(category2.getName());

        folderCategoryDAO.update(category1);

        FolderCategory catFromDB = folderCategoryDAO.getById(category1.getId());

        assertNotNull(catFromDB);
        assertEquals(category2.getName(), catFromDB.getName());
    }

}
