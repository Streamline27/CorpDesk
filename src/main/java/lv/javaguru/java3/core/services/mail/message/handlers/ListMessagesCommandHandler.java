package lv.javaguru.java3.core.services.mail.message.handlers;

import lv.javaguru.java3.core.commands.mail.message.MessageConverter;
import lv.javaguru.java3.core.commands.mail.message.list.ListMessagesCommand;
import lv.javaguru.java3.core.commands.mail.message.list.ListMessagesResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 01.12.2015.
 */
@Component
public class ListMessagesCommandHandler implements DomainCommandHandler<ListMessagesCommand, ListMessagesResult>{

    @Autowired private MessageService messageService;
    @Autowired private MessageConverter converter;

    @Override
    public ListMessagesResult execute(ListMessagesCommand command) throws Exception {

        return new ListMessagesResult(converter.convert(messageService.list(command.getFolderId())));
    }

    @Override
    public Class getCommandType() {
        return ListMessagesCommand.class;
    }
}
