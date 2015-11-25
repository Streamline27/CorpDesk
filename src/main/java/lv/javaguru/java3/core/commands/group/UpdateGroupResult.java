package lv.javaguru.java3.core.commands.group;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.user.GroupDTO;

public class UpdateGroupResult implements DomainCommandResult {

	private final GroupDTO groupDTO;

	public UpdateGroupResult(GroupDTO groupDTO) {
		this.groupDTO = groupDTO;
	}

	public GroupDTO getGroupDTO() {
		return groupDTO;
	}

}
