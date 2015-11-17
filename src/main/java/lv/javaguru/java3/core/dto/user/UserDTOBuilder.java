package lv.javaguru.java3.core.dto.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDTOBuilder {

    private Long id;
    private String login;
    private String password;
    private RoleDTO userRole;
    private String firstName;
    private String lastName;
    private String email;
    private Date lastModified;
    private StateDTO state;
    private List<GroupDTO> groups = new ArrayList<>();
    
    private UserDTOBuilder() {

    }

    public static UserDTOBuilder createUserDTO() {
        return new UserDTOBuilder();
    }

    public UserDTO build() {
        UserDTO userDTO  = new UserDTO();
        userDTO.setId(id);
        userDTO.setLogin(login);
        userDTO.setPassword(password);
        userDTO.setUserRole(userRole);
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        userDTO.setEmail(email);
        userDTO.setLastModified(lastModified);
        userDTO.setState(state);
        userDTO.setGroups(groups);
        
        return userDTO;
    }

    public UserDTOBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public UserDTOBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserDTOBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDTOBuilder withUserRole(RoleDTO userRole) {
        this.userRole = userRole;
        return this;
    }

    public UserDTOBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDTOBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDTOBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDTOBuilder withLastModified(Date lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public UserDTOBuilder withState(StateDTO state) {
        this.state = state;
        return this;
    }

    public UserDTOBuilder withGroups(List groups) {
        this.groups = groups;
        return this;
    }

}