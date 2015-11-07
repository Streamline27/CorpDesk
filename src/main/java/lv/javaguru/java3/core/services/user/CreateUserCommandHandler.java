package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.commands.user.CreateUserCommand;
import lv.javaguru.java3.core.commands.user.CreateUserResult;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CreateUserCommandHandler
		implements DomainCommandHandler<CreateUserCommand, CreateUserResult> {

	@Autowired
	private UserService userService;


	@Override
	public CreateUserResult execute(CreateUserCommand command) throws Exception {
		User user = userService.create(command.getLogin(), command.getPassword(), command.getUserRole(),
				command.getFirstName(), command.getLastName(), command.getEmail());
		return new CreateUserResult(user);
	}

	@Override
	public Class getCommandType() {
		return CreateUserCommand.class;
	}
	
}
