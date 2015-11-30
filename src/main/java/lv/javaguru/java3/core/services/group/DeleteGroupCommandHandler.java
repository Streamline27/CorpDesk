package lv.javaguru.java3.core.services.group;

import lv.javaguru.java3.core.commands.group.DeleteGroupCommand;
import lv.javaguru.java3.core.commands.group.DeleteGroupResult;
import lv.javaguru.java3.core.convertor.GroupConverter;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.group.exception.GroupNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class DeleteGroupCommandHandler
		implements DomainCommandHandler<DeleteGroupCommand, DeleteGroupResult> {

	@Autowired
	private GroupService groupService;
	@Autowired
	private GroupConverter groupConverter;


	@Override
	public DeleteGroupResult execute(DeleteGroupCommand command) throws Exception {
		long id = command.getGroupId();
		if (id==0)
			throw new GroupNotFoundException();
		else
			groupService.delete(id);
		return new DeleteGroupResult();
	}

	@Override
	public Class getCommandType() {
		return DeleteGroupCommand.class;
	}
	
}
