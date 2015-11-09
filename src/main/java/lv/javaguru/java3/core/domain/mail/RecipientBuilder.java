package lv.javaguru.java3.core.domain.mail;

import lv.javaguru.java3.core.domain.user.User;

/**
 * Created by Andrew on 08.11.2015.
 */
public class RecipientBuilder {
    private User user;
    private Folder folder;
    private boolean isUnread;
    private boolean isActive;

    public RecipientBuilder() {
    }

    public static RecipientBuilder createRecipient() {
        return new RecipientBuilder();
    }

    public Recipient build() {

        Recipient recipient = new Recipient();

        recipient.setUser(user);
        recipient.setFolder(folder);
        recipient.setIsUnread(isUnread);
        recipient.setIsActive(isActive);

        return recipient;
    }

    public RecipientBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public RecipientBuilder withFolder(Folder folder) {
        this.folder = folder;
        return this;
    }

    public RecipientBuilder isUnread(boolean isUnread) {
        this.isUnread = isUnread;
        return this;
    }

    public RecipientBuilder isActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

}
