package lv.javaguru.java3.core.services.mail;

import lv.javaguru.java3.config.AppCoreConfig;
import lv.javaguru.java3.core.database.mail.FolderDAO;
import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.services.mail.exception.FolderNotEmptyException;
import lv.javaguru.java3.core.services.mail.folder.FolderService;
import lv.javaguru.java3.core.services.mail.folder.FolderServiceImpl;
import lv.javaguru.java3.core.services.mail.folder.FolderValidator;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static lv.javaguru.java3.core.domain.mail.FolderBuilder.createFolder;
import static lv.javaguru.java3.core.domain.mail.FolderCategoryBuilder.createFolderCategory;
import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;
import static org.junit.Assert.assertEquals;

/**
 * Created by Andrew on 27.11.2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class FolderServiceTest {

    @Mock private FolderValidator folderValidator;
    @Mock private FolderDAO folderDAO;

    @InjectMocks private FolderService folderService = new FolderServiceImpl();

    @Test
    @Transactional
    public void testCreateAndList() {

        Folder folder = createFolder()
                .withName("Test Folder 1")
                .withCategory(createFolderCategory().inbox().build())
                .withUserId(1)
                .build();

        folderService.create(folder);

        assertEquals(folder.getId(), folderService.list(createUser().withId(1).build()).get(0).getId());
        assertEquals(folder.getName(), folderService.list(createUser().withId(1).build()).get(0).getName());
        assertEquals(folder.getCategory(), folderService.list(createUser().withId(1).build()).get(0).getCategory());
        assertEquals(folder.getUserId(), folderService.list(createUser().withId(1).build()).get(0).getUserId());

    }

    @Test
    @Transactional
    @Ignore
    public void testCreateMultipleAndList() {

        Folder folder1 = createFolder()
                .withName("User 1 Test Folder 1")
                .withCategory(createFolderCategory().inbox().build())
                .withUserId(2)
                .build();
        Folder folder2 = createFolder()
                .withName("User 1 Test Folder 2")
                .withCategory(createFolderCategory().inbox().build())
                .withUserId(2)
                .build();
        Folder folder3 = createFolder()
                .withName("User 2 Test Folder 1")
                .withCategory(createFolderCategory().inbox().build())
                .withUserId(3)
                .build();
        Folder folder4 = createFolder()
                .withName("User 2 Test Folder 1")
                .withCategory(createFolderCategory().inbox().build())
                .withUserId(3)
                .build();

        folderService.create(folder1);
        folderService.create(folder2);
        folderService.create(folder3);
        folderService.create(folder4);

        assertEquals(folder1.getName(), folderService.list(createUser().withId(2).build()).get(0).getName());
        assertEquals(folder2.getCategory(), folderService.list(createUser().withId(2).build()).get(1).getCategory());
        assertEquals(folder3.getUserId(), folderService.list(createUser().withId(3).build()).get(0).getUserId());
        assertEquals(folder4.getName(), folderService.list(createUser().withId(3).build()).get(1).getName());

    }

    @Test
    @Transactional
    @Ignore
    public void testDeleteEmptyFolder() {

        Folder folder = createFolder()
                .withName("Test Folder 1")
                .withCategory(createFolderCategory().inbox().build())
                .withUserId(4)
                .build();

        folderService.create(folder);

        try {
            folderService.delete(folder);
        } catch (FolderNotEmptyException e) {
            e.printStackTrace();
        }

        assertEquals(0, folderService.list(createUser().withId(4).build()).size());

    }

    @Test
    @Transactional
    @Ignore
    public void testDeleteNotEmptyFolder() {

    }

    @Test
    @Transactional
    @Ignore
    public void testGetMessageCount() {

    }
}
