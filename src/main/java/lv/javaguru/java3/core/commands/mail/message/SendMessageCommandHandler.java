package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 30.11.2015.
 */
@Component
public class SendMessageCommandHandler implements DomainCommandHandler<SendMessageCommand, VoidResult> {

    @Autowired private MessageService messageService;

    @Override
    public VoidResult execute(SendMessageCommand command) throws Exception {

        messageService.send(command.getSender(), command.getTitle(), command.getBody(), command.getRecipients(), command.isImportant());

        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return SendMessageCommand.class;
    }

}
