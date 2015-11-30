package lv.javaguru.java3.core.domain.mail;

/**
 * Created by Andrew on 08.11.2015.
 */
public class FolderCategoryBuilder {
    private long id;
    private String name;

    public FolderCategoryBuilder() {
    }

    public static FolderCategoryBuilder createFolderCategory() {
        return new FolderCategoryBuilder();
    }

    public FolderCategory build() {

        FolderCategory category = new FolderCategory();

        category.setId(id);
        category.setName(name);

        return category;

    }

    public FolderCategoryBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public FolderCategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public FolderCategoryBuilder inbox() {
        this.id = 1;
        this.name = "Inbox";
        return this;
    }

    public FolderCategoryBuilder sent() {
        this.id = 2;
        this.name = "Sent";
        return this;
    }

    public FolderCategoryBuilder draft() {
        this.id = 3;
        this.name = "Draft";
        return this;
    }

    public FolderCategoryBuilder deleted() {
        this.id = 4;
        this.name = "Deleted";
        return this;
    }

    public FolderCategoryBuilder custom() {
        this.id = 5;
        this.name = "Custom";
        return this;
    }

}
