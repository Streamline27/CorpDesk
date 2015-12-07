package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.folder.FolderService;
import lv.javaguru.java3.core.services.mail.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 02.12.2015.
 */
@Component
public class GetMessageCountCommandHandler implements DomainCommandHandler<GetMessageCountCommand, GetMessageCountResult>{

    @Autowired private MessageService messageService;
    @Autowired private FolderService folderService;
    @Autowired private MessageCountConverter converter;

    @Override
    public GetMessageCountResult execute(GetMessageCountCommand command) throws Exception {
        return new GetMessageCountResult(
                converter.convert(
                        messageService.getMessagesCount(
                                folderService.get(command.getFolderId()))));
    }

    @Override
    public Class getCommandType() {
        return GetMessageCountCommand.class;
    }
}
