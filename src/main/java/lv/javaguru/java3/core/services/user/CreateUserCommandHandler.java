package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.commands.user.CreateUserCommand;
import lv.javaguru.java3.core.commands.user.CreateUserResult;
import lv.javaguru.java3.core.convertor.UserConverter;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CreateUserCommandHandler
		implements DomainCommandHandler<CreateUserCommand, CreateUserResult> {

	@Autowired
	private UserService userService;
	@Autowired
	private UserConverter userConverter;


	@Override
	public CreateUserResult execute(CreateUserCommand command) throws Exception {
		User user = userConverter.convertDTO(command.getUserDTO());
		userService.create(user);
		return new CreateUserResult(userConverter.convert(user));
	}

	@Override
	public Class getCommandType() {
		return CreateUserCommand.class;
	}
	
}
