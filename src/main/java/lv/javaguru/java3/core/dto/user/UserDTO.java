package lv.javaguru.java3.core.dto.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDTO implements Serializable {

    private long id;
    private String login;
    private String password;
    private RoleDTO userRole;
    private String firstName;
    private String lastName;
    private String email;
    private Date lastModified;
    private StateDTO state;
    private List<GroupDTO> groups = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDTO getUserRole() {
        return userRole;
    }

    public void setUserRole(RoleDTO userRole) {
        this.userRole = userRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public StateDTO getState() {
        return state;
    }

    public void setState(StateDTO state) {
        this.state = state;
    }

    public List<GroupDTO> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDTO> groups) {
        this.groups = groups;
    }
}