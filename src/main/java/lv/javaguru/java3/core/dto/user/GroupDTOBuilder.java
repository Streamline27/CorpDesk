package lv.javaguru.java3.core.dto.user;

import java.util.Date;
import java.util.List;

public class GroupDTOBuilder {

    private long id;
    private String name;
    private StateDTO state;
    private Date lastModified;
    private List<UserDTO> users;

    private GroupDTOBuilder() {}

    public static GroupDTOBuilder createGroupDTO() { return new GroupDTOBuilder(); }

    public GroupDTO build() {

        GroupDTO groupDTO  = new GroupDTO();
        groupDTO.setId(id);
        groupDTO.setName(name);
        groupDTO.setState(state);
        groupDTO.setLastModified(lastModified);
        groupDTO.setUsers(users);

        return groupDTO;

    }

    public GroupDTOBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public GroupDTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public GroupDTOBuilder withState(StateDTO state) {
        this.state = state;
        return this;
    }

    public GroupDTOBuilder withLastModified(Date lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public GroupDTOBuilder withUsers(List<UserDTO> users) {
        this.users = users;
        return this;
    }

}
