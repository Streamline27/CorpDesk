package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 01.12.2015.
 */
@Component
public class GetMessageCommandHandler implements DomainCommandHandler<GetMessageCommand, GetMessageResult>{

    @Autowired private MessageService messageService;
    @Autowired private MessageConverter messageConverter;

    @Override
    public GetMessageResult execute(GetMessageCommand command) throws Exception {

        return new GetMessageResult(messageConverter
                .convert(messageService.get(command.getMessageId())));

    }

    @Override
    public Class getCommandType() {
        return GetMessageCommand.class;
    }
}
