package lv.javaguru.java3.core.commands.user;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.domain.user.Role;

public class CreateUserCommand implements DomainCommand<CreateUserResult> {

    private final String login;
    private final String password;
    private final Role userRole;
    private final String firstName;
    private final String lastName;
    private final String email;

    public CreateUserCommand(String login, String password, Role userRole, String firstName, String lastName, String email) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getUserRole() {
        return userRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
