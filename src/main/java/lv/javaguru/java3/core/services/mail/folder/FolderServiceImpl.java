package lv.javaguru.java3.core.services.mail.folder;

import lv.javaguru.java3.core.database.mail.FolderDAO;
import lv.javaguru.java3.core.database.mail.RecipientDAO;
import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.FolderType;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.mail.exception.FolderNotEmptyException;
import lv.javaguru.java3.core.services.mail.exception.InvalidFolderOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static lv.javaguru.java3.core.domain.mail.FolderBuilder.createFolder;

/**
 * Created by Andrew on 21.11.2015.
 */
@Component
public class FolderServiceImpl implements FolderService {

    @Autowired private FolderDAO folderDAO;
    @Autowired private FolderValidator validator;
    @Autowired private RecipientDAO recipientDAO;

    @Override
    public void create(Folder folder) {
        validator.validate(folder);

        folderDAO.create(folder);
    }

    @Override
    public Folder get(long folderId) throws Exception{
        return folderDAO.getRequired(folderId);
    }

    @Override
    public void delete(Folder folder) throws FolderNotEmptyException, InvalidFolderOperationException {
        if (recipientDAO.getMessagesCount(folder.getId()) > 0)
            throw new FolderNotEmptyException();

        if (!isUserCreated(folder))
            throw new InvalidFolderOperationException();

        folderDAO.delete(folder);
    }

    @Override
    public List<Folder> list(User user) {
        return folderDAO.listByUserId(user.getId());
    }

    @Override
    public Folder getInbox(User user) {
        return getFolder(user, FolderType.INBOX, "Inbox");
    }

    @Override
    public Folder getSent(User user) {
        return getFolder(user, FolderType.SENT, "Sent");
    }

    @Override
    public Folder getDraft(User user) {
        return getFolder(user, FolderType.DRAFT, "Draft");
    }

    @Override
    public Folder getDeleted(User user) {
        return getFolder(user, FolderType.DELETED, "Deleted");
    }

    private Folder getFolder(User user, FolderType folderType, String folderName) {
        Folder folder;
        try {
            folder = folderDAO.getByType(user.getId(), folderType);
        } catch (IndexOutOfBoundsException e) {
            folderDAO.create(
                    createFolder()
                            .withUserId(user.getId())
                            .withName(folderName)
                            .withType(folderType)
                            .build()
            );
            folder = folderDAO.getByType(user.getId(), folderType);
        }
        return folder;
    }

    @Override
    public boolean isInbox(Folder folder) {
        return folder.getFolderType() == FolderType.INBOX;
    }

    @Override
    public boolean isSent(Folder folder) {
        return folder.getFolderType() == FolderType.SENT;
    }

    @Override
    public boolean isDraft(Folder folder) {
        return folder.getFolderType() == FolderType.DRAFT;
    }

    @Override
    public boolean isDeleted(Folder folder) {
        return folder.getFolderType() == FolderType.DELETED;
    }

    @Override
    public boolean isUserCreated(Folder folder) {
        return folder.getFolderType() == FolderType.USER_CREATED;
    }
}
