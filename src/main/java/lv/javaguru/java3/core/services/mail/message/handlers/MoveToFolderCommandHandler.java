package lv.javaguru.java3.core.services.mail.message.handlers;

import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.commands.mail.message.move.MoveToFolderCommand;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.mail.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 01.12.2015.
 */
@Component
public class MoveToFolderCommandHandler implements DomainCommandHandler<MoveToFolderCommand, VoidResult>{

    @Autowired private MessageService messageService;

    @Override
    public VoidResult execute(MoveToFolderCommand command) throws Exception {

        messageService.moveToFolder(
                command.getMessageId(),
                command.getUserId(),
                command.getNewFolderId());

        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return MoveToFolderCommand.class;
    }
}
