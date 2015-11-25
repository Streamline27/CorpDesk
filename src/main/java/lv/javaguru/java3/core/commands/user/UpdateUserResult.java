package lv.javaguru.java3.core.commands.user;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.user.UserDTO;

public class UpdateUserResult implements DomainCommandResult {

	private final UserDTO userDTO;

	public UpdateUserResult(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

}
