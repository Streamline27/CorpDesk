package lv.javaguru.java3.core.commands.user;

import lv.javaguru.java3.core.commands.DomainCommand;

public class GetUserCommand implements DomainCommand<GetUserResult> {

    private final long userId;

    public GetUserCommand(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
