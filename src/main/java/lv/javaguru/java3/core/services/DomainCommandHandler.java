package lv.javaguru.java3.core.services;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.services.user.exception.InvalidPasswordException;

public interface DomainCommandHandler<C extends DomainCommand, R extends DomainCommandResult> {

    R execute(C command) throws Exception, InvalidPasswordException;

    Class getCommandType();

}
