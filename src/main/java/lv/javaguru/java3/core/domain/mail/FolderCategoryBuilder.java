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

    public FolderCategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

}
