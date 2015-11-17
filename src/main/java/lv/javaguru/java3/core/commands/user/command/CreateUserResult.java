package lv.javaguru.java3.core.commands.user.command;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.user.UserDTO;

public class CreateUserResult implements DomainCommandResult {

	private final UserDTO userDTO;

	public CreateUserResult(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

}
