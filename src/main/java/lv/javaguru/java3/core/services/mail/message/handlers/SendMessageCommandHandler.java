package lv.javaguru.java3.core.services.mail.message.handlers;

import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.commands.mail.message.send.SendMessageCommand;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.message.MessageService;
import lv.javaguru.java3.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 30.11.2015.
 */
@Component
public class SendMessageCommandHandler implements DomainCommandHandler<SendMessageCommand, VoidResult> {

    @Autowired private MessageService messageService;
    @Autowired private UserService userService;

    @Override
    public VoidResult execute(SendMessageCommand command) throws Exception {

        messageService.send(
                getUser(command.getSender().getLogin()).getId(),
                command.getTitle(),
                command.getBody(),
                command.getRecipients(),
                command.isImportant());

        return VoidResult.INSTANCE;
    }

    private User getUser(String login) {
        return userService.get(login);
    }

    @Override
    public Class getCommandType() {
        return SendMessageCommand.class;
    }

}
