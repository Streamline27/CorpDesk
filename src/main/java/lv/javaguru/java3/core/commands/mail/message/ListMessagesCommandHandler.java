package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Andrew on 01.12.2015.
 */
public class ListMessagesCommandHandler implements DomainCommandHandler<ListMessagesCommand, ListMessagesResult>{

    @Autowired private MessageService service;
    @Autowired private MessageConverter converter;

    @Override
    public ListMessagesResult execute(ListMessagesCommand command) throws Exception {

        return new ListMessagesResult(converter.convert(service.list(command.getFolderId())));
    }

    @Override
    public Class getCommandType() {
        return ListMessagesCommand.class;
    }
}
