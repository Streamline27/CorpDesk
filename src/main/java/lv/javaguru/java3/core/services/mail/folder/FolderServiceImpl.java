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
        return folderDAO.getByType(user.getId(), FolderType.INBOX);
    }

    @Override
    public Folder getSent(User user) {
        return folderDAO.getByType(user.getId(), FolderType.SENT);
    }

    @Override
    public Folder getDraft(User user) {
        return folderDAO.getByType(user.getId(), FolderType.DRAFT);
    }

    @Override
    public Folder getDeleted(User user) {
        return folderDAO.getByType(user.getId(), FolderType.DELETED);
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
