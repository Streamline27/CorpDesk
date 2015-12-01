package lv.javaguru.java3.core.domain.user;


import lv.javaguru.java3.core.dto.user.UserDTO;

import java.util.Date;
import java.util.List;

public class GroupBuilder {

    private long id;
    private String name;
    private State state;
    private Date lastModified;
    private List<User> users;

    private GroupBuilder() {}

    public static GroupBuilder createGroup() { return new GroupBuilder(); }

    public Group build() {

        Group group  = new Group();
        group.setId(id);
        group.setName(name);
        group.setState(state);
        group.setLastModified(lastModified);
        group.setUsers(users);

        return group;

    }

    public GroupBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public GroupBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public GroupBuilder withState(State state) {
        this.state = state;
        return this;
    }

    public GroupBuilder withLastModified(Date lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public GroupBuilder withUsers(List<User> users) {
        this.users = users;
        return this;
    }

}
