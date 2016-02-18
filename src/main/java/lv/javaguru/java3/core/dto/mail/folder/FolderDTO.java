package lv.javaguru.java3.core.dto.mail.folder;

import lv.javaguru.java3.core.domain.mail.FolderCategory;

import java.io.Serializable;

/**
 * Created by Andrew on 02.12.2015.
 */
public class FolderDTO implements Serializable{

    private long id;
    private String name;
    private long userId;
    private boolean isRemovable;
    private long messageCount;
    private long unreadMessageCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isRemovable() {
        return isRemovable;
    }

    public void setIsRemovable(boolean isRemovable) {
        this.isRemovable = isRemovable;
    }

    public long getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(long messageCount) {
        this.messageCount = messageCount;
    }

    public long getUnreadMessageCount() {
        return unreadMessageCount;
    }

    public void setUnreadMessageCount(long unreadMessageCount) {
        this.unreadMessageCount = unreadMessageCount;
    }
}
