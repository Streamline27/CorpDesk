package lv.javaguru.java3.core.commands.user;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.domain.user.User;

public class CreateUserResult implements DomainCommandResult {

	private final User user;

	public CreateUserResult(User user1) {
		this.user = user1;
	}

	public User getUser() {
		return user;
	}

}
