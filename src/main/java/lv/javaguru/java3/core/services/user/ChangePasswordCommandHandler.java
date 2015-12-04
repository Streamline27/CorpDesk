package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.commands.user.ChangePasswordCommand;
import lv.javaguru.java3.core.commands.user.ChangePasswordResult;
import lv.javaguru.java3.core.dto.user.ChangePasswordDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ChangePasswordCommandHandler
		implements DomainCommandHandler<ChangePasswordCommand, ChangePasswordResult> {

	@Autowired
	private UserService userService;


	@Override
	public ChangePasswordResult execute(ChangePasswordCommand command) throws Exception {
		ChangePasswordDTO dto = command.getChangePasswordDTO();
		userService.changePassword(dto.getLogin(), dto.getOldPassword(), dto.getNewPassword());
		return new ChangePasswordResult();
	}

	@Override
	public Class getCommandType() {
		return ChangePasswordCommand.class;
	}
	
}
