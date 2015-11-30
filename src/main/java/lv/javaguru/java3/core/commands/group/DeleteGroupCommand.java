package lv.javaguru.java3.core.commands.group;

import lv.javaguru.java3.core.commands.DomainCommand;

public class DeleteGroupCommand implements DomainCommand<DeleteGroupResult> {

    private final long groupId;

    public DeleteGroupCommand(long groupId) {
        this.groupId = groupId;
    }

    public long getGroupId() {
        return groupId;
    }
}
