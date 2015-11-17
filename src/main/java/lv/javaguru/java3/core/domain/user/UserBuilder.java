package lv.javaguru.java3.core.domain.user;


import java.sql.Date;
import java.util.List;

public class UserBuilder {

    private long id;
    private String login;
    private String password;
    private Role userRole;
    private String firstName;
    private String lastName;
    private String email;
    private Date lastModified;
    private State state;
    private List<Group> groups;

    private UserBuilder() {}

    public static UserBuilder createUser() { return new UserBuilder(); }

    public User build() {

        User user  = new User();
        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setUserRole(userRole);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setLastModified(lastModified);
        user.setState(state);
        user.setGroups(groups);

        return user;

    }

    public UserBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public UserBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withUserRole(Role userRole) {
        this.userRole = userRole;
        return this;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withLastModified(Date lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public UserBuilder withState(State state) {
        this.state = state;
        return this;
    }

    public UserBuilder withGroups(List groups) {
        this.groups = groups;
        return this;
    }
}
