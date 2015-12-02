package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Andrew on 01.12.2015.
 */
public class GetUnreadMessageCountHandler implements DomainCommandHandler<GetUnreadMessageCountCommand, GetUnreadMessageCountResult>{

    @Autowired private MessageService messageService;
    @Autowired private MessageCountConverter converter;

    @Override
    public GetUnreadMessageCountResult execute(GetUnreadMessageCountCommand command) throws Exception {
        return new GetUnreadMessageCountResult(
                converter.convert(messageService.getUnreadMessageCount(command.getFolderId())));
    }

    @Override
    public Class getCommandType() {
        return GetUnreadMessageCountCommand.class;
    }
}
