package lv.javaguru.java3.core.commands.group;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.user.GroupDTO;

public class CreateGroupResult implements DomainCommandResult {

	private final GroupDTO groupDTO;

	public CreateGroupResult(GroupDTO groupDTO) {
		this.groupDTO = groupDTO;
	}

	public GroupDTO getGroupDTO() {
		return groupDTO;
	}

}
