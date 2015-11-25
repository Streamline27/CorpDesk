package lv.javaguru.java3.core.commands.user;

import lv.javaguru.java3.core.commands.DomainCommand;

public class DeleteUserCommand implements DomainCommand<DeleteUserResult> {

    private final long userId;

    public DeleteUserCommand(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
