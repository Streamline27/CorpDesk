package lv.javaguru.java3.rest.mail;

import lv.javaguru.java3.core.commands.mail.folder.GetFolderCommand;
import lv.javaguru.java3.core.commands.mail.folder.GetFolderResult;
import lv.javaguru.java3.core.dto.mail.folder.FolderDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Andrew on 02.12.2015.
 */
@Path("/mail_folder")
@Component
public class FolderResourceImpl implements FolderResource {

    private CommandExecutor commandExecutor;

    @Autowired
    public FolderResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public FolderDTO get(@QueryParam("folderId") Long folderId) throws Exception {
        GetFolderCommand command = new GetFolderCommand(folderId==null? 0 : folderId);
        GetFolderResult result = commandExecutor.execute(command);
        return result.getFolderDTO();
    }
}
