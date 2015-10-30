package lv.javaguru.java3.core.domain.user;


import java.sql.Date;

public class GroupBuilder {

    private long id;
    private String name;
    private Date lastModified;

    private GroupBuilder() {}

    public static GroupBuilder createGroup() { return new GroupBuilder(); }

    public Group build() {

        Group group  = new Group();
        group.setId(id);
        group.setName(name);
        group.setLastModified(lastModified);

        return group;

    }

    public GroupBuilder withName(String name) {
        this.name = name;
        return this;
    }

}
