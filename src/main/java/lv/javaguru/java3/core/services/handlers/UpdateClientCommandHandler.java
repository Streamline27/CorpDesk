package lv.javaguru.java3.core.services.handlers;

import lv.javaguru.java3.core.commands.clients.UpdateClientCommand;
import lv.javaguru.java3.core.commands.clients.UpdateClientResult;
import lv.javaguru.java3.core.domain.client.Client;
import lv.javaguru.java3.core.services.client.ClientService;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class UpdateClientCommandHandler
        implements DomainCommandHandler<UpdateClientCommand, UpdateClientResult> {

    @Autowired
    private ClientService clientService;


    @Override
    public UpdateClientResult execute(UpdateClientCommand command) {
        Client client = clientService.update(
                command.getClientId(),
                command.getLogin(),
                command.getPassword()
        );
        return new UpdateClientResult(client);
    }

    @Override
    public Class getCommandType() {
        return UpdateClientCommand.class;
    }

}
