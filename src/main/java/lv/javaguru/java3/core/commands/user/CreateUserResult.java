package lv.javaguru.java3.core.commands.user;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.domain.user.User;

public class CreateUserResult implements DomainCommandResult {

	private final User user;

	public CreateUserResult(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

}
