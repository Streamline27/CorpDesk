package lv.javaguru.java3.core.domain.mail;


/**
 * Created by Andrew on 08.11.2015.
 */
public class FolderBuilder {

    private long id;
    private long userId;
    private String name;
    private FolderType folderType;

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
        folder.setFolderType(folderType);

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

    public FolderBuilder withType(FolderType folderType) {
        this.folderType = folderType;
        return this;
    }

}
