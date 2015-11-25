package lv.javaguru.java3.core.commands.user;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.user.UserDTO;

import java.util.List;

public class GetUserResult implements DomainCommandResult {

	private final List<UserDTO> userDTOs;

	public GetUserResult(List<UserDTO> userDTOs) {
		this.userDTOs = userDTOs;
	}

	public List<UserDTO> getUserDTO() {
		return userDTOs;
	}

}
