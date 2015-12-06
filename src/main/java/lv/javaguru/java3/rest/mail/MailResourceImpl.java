package lv.javaguru.java3.rest.mail;

import lv.javaguru.java3.core.commands.mail.message.SendMessageCommand;
import lv.javaguru.java3.core.dto.mail.message.MessageDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Andrew on 02.12.2015.
 */
public class MailResourceImpl implements MailResource {

    private CommandExecutor commandExecutor;

    @Autowired
    public MailResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public void send(MessageDTO messageDTO) throws Exception {
        SendMessageCommand command = new SendMessageCommand(
                messageDTO.getSender(),
                messageDTO.getTitle(),
                messageDTO.getBody(),
                messageDTO.isImportant(),
                messageDTO.getRecipients());
        commandExecutor.execute(command);
    }


}
