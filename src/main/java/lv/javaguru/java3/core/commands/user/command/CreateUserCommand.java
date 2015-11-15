package lv.javaguru.java3.core.commands.user.command;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.dto.user.UserDTO;

public class CreateUserCommand implements DomainCommand<CreateUserResult> {

    private final UserDTO userDTO;

    public CreateUserCommand(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}
