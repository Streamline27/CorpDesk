package lv.javaguru.java3.core.services.mail.folder;

import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.mail.exception.FolderNotEmptyException;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Andrew on 17.11.2015.
 */
public interface FolderService {

    void create(Folder folder);

    void delete(Folder folder) throws FolderNotEmptyException;

    List<Folder> list(User user);

    int getMessagesCount(Folder folder);


    Folder getInbox(User user);

    Folder getSent(User user);

    Folder getDraft(User user);

    Folder getDeleted(User user);


    boolean isInbox(Folder folder);

    boolean isSent(Folder folder);

    boolean isDraft(Folder folder);

    boolean isDeleted(Folder folder);

    boolean isCustom(Folder folder);

}
