package lv.javaguru.java3.core.domain.mail;


/**
 * Created by Andrew on 08.11.2015.
 */
public class FolderBuilder {

    private long id;
    private long userId;
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
        folder.setUserId(userId);
        folder.setName(name);
        folder.setCategory(category);

        return folder;
    }

    public FolderBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public FolderBuilder withUserId(long userId) {
        this.userId = userId;
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
