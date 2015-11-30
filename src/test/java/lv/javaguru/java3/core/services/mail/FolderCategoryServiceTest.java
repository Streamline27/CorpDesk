package lv.javaguru.java3.core.services.mail;

import lv.javaguru.java3.config.AppCoreConfig;
import lv.javaguru.java3.core.domain.mail.FolderCategory;
import lv.javaguru.java3.core.services.mail.folder_category.FolderCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andrew on 26.11.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AppCoreConfig.class})
public class FolderCategoryServiceTest {

    @Autowired private FolderCategoryService service;

    @Test
    @Transactional
    public void testList() {

        List<FolderCategory> folderCategoryList = service.list();

        assertEquals(5, folderCategoryList.size());

        assertEquals(1, folderCategoryList.get(0).getId());
        assertEquals("Inbox", folderCategoryList.get(0).getName());

        assertEquals(2, folderCategoryList.get(1).getId());
        assertEquals("Sent", folderCategoryList.get(1).getName());

        assertEquals(3, folderCategoryList.get(2).getId());
        assertEquals("Draft", folderCategoryList.get(2).getName());

        assertEquals(4, folderCategoryList.get(3).getId());
        assertEquals("Deleted", folderCategoryList.get(3).getName());

        assertEquals(5, folderCategoryList.get(4).getId());
        assertEquals("Custom", folderCategoryList.get(4).getName());

    }

    @Test
    @Transactional
    public void testGetInbox() {
        assertEquals(1, service.getInbox().getId());
        assertEquals("Inbox", service.getInbox().getName());
    }

    @Test
    @Transactional
    public void testGetSent() {
        assertEquals(2, service.getSent().getId());
        assertEquals("Sent", service.getSent().getName());
    }

    @Test
    @Transactional
    public void testGetDraft() {
        assertEquals(3, service.getDraft().getId());
        assertEquals("Draft", service.getDraft().getName());
    }

    @Test
    @Transactional
    public void testGetDeleted() {
        assertEquals(4, service.getDeleted().getId());
        assertEquals("Deleted", service.getDeleted().getName());
    }

    @Test
    @Transactional
    public void testGetCustom() {
        assertEquals(5, service.getCustom().getId());
        assertEquals("Custom", service.getCustom().getName());
    }


}
