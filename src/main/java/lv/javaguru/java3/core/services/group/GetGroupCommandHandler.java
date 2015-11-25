package lv.javaguru.java3.core.services.group;

import lv.javaguru.java3.core.commands.group.GetGroupCommand;
import lv.javaguru.java3.core.commands.group.GetGroupResult;
import lv.javaguru.java3.core.convertor.GroupConverter;
import lv.javaguru.java3.core.domain.user.Group;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class GetGroupCommandHandler
		implements DomainCommandHandler<GetGroupCommand, GetGroupResult> {

	@Autowired
	private GroupService groupService;
	@Autowired
	private GroupConverter groupConverter;


	@Override
	public GetGroupResult execute(GetGroupCommand command) throws Exception {
		long id = command.getGroupId();
		List<Group> groups = new ArrayList<>();
		if (id==0)
			groups = groupService.getAll();
		else
			groups.add(groupService.get(id));
		return new GetGroupResult(groupConverter.convert(groups));
	}

	@Override
	public Class getCommandType() {
		return GetGroupCommand.class;
	}
	
}
