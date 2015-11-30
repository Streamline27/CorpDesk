package lv.javaguru.java3.core.domain.mail;

/**
 * Created by Andrew on 08.11.2015.
 */
public class RecipientBuilder {
    private long userId;
    private long messageId;
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

        recipient.setUserId(userId);
        recipient.setMessageId(messageId);
        recipient.setFolder(folder);
        recipient.setIsUnread(isUnread);
        recipient.setIsActive(isActive);

        return recipient;
    }

    public RecipientBuilder withUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public RecipientBuilder withMessageId(long messageId) {
        this.messageId = messageId;
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
