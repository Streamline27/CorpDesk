package lv.javaguru.java3.core.commands.user;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.user.UserDTO;

public class ChangePasswordResult implements DomainCommandResult {

	private final int code;

	public ChangePasswordResult(int code) {
		this.code = code;
	}

	public int getResponse() {
		return code;
	}

}
