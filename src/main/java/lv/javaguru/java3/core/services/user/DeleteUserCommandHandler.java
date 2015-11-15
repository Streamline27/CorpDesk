package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.commands.user.command.DeleteUserCommand;
import lv.javaguru.java3.core.commands.user.command.DeleteUserResult;
import lv.javaguru.java3.core.commands.user.convertor.UserConverter;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class DeleteUserCommandHandler
		implements DomainCommandHandler<DeleteUserCommand, DeleteUserResult> {

	@Autowired
	private UserService userService;
	@Autowired
	private UserConverter userConverter;


	@Override
	public DeleteUserResult execute(DeleteUserCommand command) throws Exception {
		long id = command.getUserId();
		if (id==0)
			throw new UserNotFoundException();
		else
			userService.delete(id);
		return new DeleteUserResult();
	}

	@Override
	public Class getCommandType() {
		return DeleteUserCommand.class;
	}
	
}
