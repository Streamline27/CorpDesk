package lv.javaguru.java3.core.commands.user;

import lv.javaguru.java3.core.commands.DomainCommandResult;

public class AuthorizeUserResult implements DomainCommandResult {

	private final int code;

	public AuthorizeUserResult(int code) {
		this.code = code;
	}

	public int getResponse() {
		return code;
	}

}
