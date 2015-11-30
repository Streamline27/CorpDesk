package lv.javaguru.java3.core.commands.group;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.dto.user.GroupDTO;

public class UpdateGroupCommand implements DomainCommand<UpdateGroupResult> {

    private final GroupDTO groupDTO;

    public UpdateGroupCommand(GroupDTO groupDTO) {
        this.groupDTO = groupDTO;
    }

    public GroupDTO getGroupDTO() {
        return groupDTO;
    }
}
