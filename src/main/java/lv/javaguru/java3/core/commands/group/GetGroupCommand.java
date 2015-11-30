package lv.javaguru.java3.core.commands.group;

import lv.javaguru.java3.core.commands.DomainCommand;

public class GetGroupCommand implements DomainCommand<GetGroupResult> {

    private final long groupId;

    public GetGroupCommand(long groupId) {
        this.groupId = groupId;
    }

    public long getGroupId() {
        return groupId;
    }
}
