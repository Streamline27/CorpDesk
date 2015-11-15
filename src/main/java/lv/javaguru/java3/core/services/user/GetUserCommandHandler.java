package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.commands.user.command.GetUserCommand;
import lv.javaguru.java3.core.commands.user.command.GetUserResult;
import lv.javaguru.java3.core.commands.user.convertor.UserConverter;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class GetUserCommandHandler
		implements DomainCommandHandler<GetUserCommand, GetUserResult> {

	@Autowired
	private UserService userService;
	@Autowired
	private UserConverter userConverter;


	@Override
	public GetUserResult execute(GetUserCommand command) throws Exception {
		long id = command.getUserId();
		List<User> users = new ArrayList<>();
		if (id==0)
			users = userService.getAll();
		else
			users.add(userService.get(id));
		return new GetUserResult(userConverter.convert(users));
	}

	@Override
	public Class getCommandType() {
		return GetUserCommand.class;
	}
	
}
