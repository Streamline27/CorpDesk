package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Andrew on 01.12.2015.
 */
public class DeleteMessageCommandHandler implements DomainCommandHandler<DeleteMessageCommand, VoidResult>{

    @Autowired private MessageService messageService;
    @Override
    public VoidResult execute(DeleteMessageCommand command) throws Exception {

        messageService.delete(command.getUserId(), command.getMessageId());

        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return DeleteMessageCommand.class;
    }
}
