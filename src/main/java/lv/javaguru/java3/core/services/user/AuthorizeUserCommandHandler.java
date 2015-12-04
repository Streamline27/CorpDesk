package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.commands.user.AuthorizeUserCommand;
import lv.javaguru.java3.core.commands.user.AuthorizeUserResult;
import lv.javaguru.java3.core.commands.user.UpdateUserCommand;
import lv.javaguru.java3.core.dto.user.UserDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class AuthorizeUserCommandHandler
		implements DomainCommandHandler<AuthorizeUserCommand, AuthorizeUserResult> {

	@Autowired
	private UserService userService;


	@Override
	public AuthorizeUserResult execute(AuthorizeUserCommand command) throws Exception {
		UserDTO userDTO = command.getUserDTO();
		int code=userService.validate(userDTO.getLogin(), userDTO.getPassword());
		return new AuthorizeUserResult(code);
	}

	@Override
	public Class getCommandType() {
		return AuthorizeUserCommand.class;
	}
	
}
