package lv.javaguru.java3.core.commands.user;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.dto.user.UserDTO;

public class AuthorizeUserCommand implements DomainCommand<AuthorizeUserResult> {

    private final UserDTO userDTO;

    public AuthorizeUserCommand(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}
