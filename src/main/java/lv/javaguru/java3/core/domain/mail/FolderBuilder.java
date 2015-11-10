package lv.javaguru.java3.core.domain.mail;

import lv.javaguru.java3.core.domain.user.User;

/**
 * Created by Andrew on 08.11.2015.
 */
public class FolderBuilder {

    private long id;
    private User user;
    private String name;
    private FolderCategory category;

    public FolderBuilder() {
    }

    public static FolderBuilder createFolder() {
        return new FolderBuilder();
    }

    public Folder build() {

        Folder folder = new Folder();

        folder.setId(id);
        folder.setUser(user);
        folder.setName(name);
        folder.setCategory(category);

        return folder;
    }

    public FolderBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public FolderBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public FolderBuilder withCategory(FolderCategory category) {
        this.category = category;
        return this;
    }

}
