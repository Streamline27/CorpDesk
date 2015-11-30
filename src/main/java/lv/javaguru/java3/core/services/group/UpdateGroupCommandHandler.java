package lv.javaguru.java3.core.services.group;

import lv.javaguru.java3.core.commands.group.UpdateGroupCommand;
import lv.javaguru.java3.core.commands.group.UpdateGroupResult;
import lv.javaguru.java3.core.convertor.GroupConverter;
import lv.javaguru.java3.core.domain.user.Group;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class UpdateGroupCommandHandler
		implements DomainCommandHandler<UpdateGroupCommand, UpdateGroupResult> {

	@Autowired
	private GroupService groupService;
	@Autowired
	private GroupConverter groupConverter;


	@Override
	public UpdateGroupResult execute(UpdateGroupCommand command) throws Exception {
		Group group = groupConverter.convertDTO(command.getGroupDTO());
		groupService.update(group);
		return new UpdateGroupResult(groupConverter.convert(group));
	}

	@Override
	public Class getCommandType() {
		return UpdateGroupCommand.class;
	}
	
}
