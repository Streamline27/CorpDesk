package lv.javaguru.java3.core.services.group;

import lv.javaguru.java3.core.commands.group.CreateGroupCommand;
import lv.javaguru.java3.core.commands.group.CreateGroupResult;
import lv.javaguru.java3.core.convertor.GroupConverter;
import lv.javaguru.java3.core.domain.user.Group;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CreateGroupCommandHandler
		implements DomainCommandHandler<CreateGroupCommand, CreateGroupResult> {

	@Autowired
	private GroupService groupService;
	@Autowired
	private GroupConverter groupConverter;


	@Override
	public CreateGroupResult execute(CreateGroupCommand command) throws Exception {
		Group group = groupConverter.convertDTO(command.getGroupDTO());
		groupService.create(group);
		return new CreateGroupResult(groupConverter.convert(group));
	}

	@Override
	public Class getCommandType() {
		return CreateGroupCommand.class;
	}
	
}
