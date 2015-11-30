package lv.javaguru.java3.core.commands.group;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.user.GroupDTO;

import java.util.List;

public class GetGroupResult implements DomainCommandResult {

	private final List<GroupDTO> groupDTOs;

	public GetGroupResult(List<GroupDTO> groupDTOs) {
		this.groupDTOs = groupDTOs;
	}

	public List<GroupDTO> getGroupDTO() {
		return groupDTOs;
	}

}
