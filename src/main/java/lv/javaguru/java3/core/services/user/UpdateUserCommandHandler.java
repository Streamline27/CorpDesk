package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.commands.user.UpdateUserCommand;
import lv.javaguru.java3.core.commands.user.UpdateUserResult;
import lv.javaguru.java3.core.convertor.UserConverter;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class UpdateUserCommandHandler
		implements DomainCommandHandler<UpdateUserCommand, UpdateUserResult> {

	@Autowired
	private UserService userService;
	@Autowired
	private UserConverter userConverter;


	@Override
	public UpdateUserResult execute(UpdateUserCommand command) throws Exception {
		User user = userConverter.convertDTO(command.getUserDTO());
		return new UpdateUserResult(userConverter.convert(userService.update(user)));
	}

	@Override
	public Class getCommandType() {
		return UpdateUserCommand.class;
	}
	
}
