package lv.javaguru.java3.rest.mail;

import com.google.gson.Gson;
import lv.javaguru.java3.core.commands.mail.folder.*;
import lv.javaguru.java3.core.dto.mail.folder.FolderDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import lv.javaguru.java3.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Andrew on 02.12.2015.
 */
@Path("/mail/folder")
@Component
public class FolderResourceImpl implements FolderResource {

    private CommandExecutor commandExecutor;
    private Gson gson;

    @Autowired
    public FolderResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        this.gson = new Gson();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Override
    public Response create(FolderDTO folderDTO) throws Exception {
        try {
            CreateFolderCommand command = new CreateFolderCommand(folderDTO);
            commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response get(@QueryParam("folderId") Long folderId) throws Exception {
        try {
            GetFolderCommand command = new GetFolderCommand(folderId);
            GetFolderResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getFolderDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response delete(@QueryParam("folderId") Long id) throws Exception {
        try {
            DeleteFolderCommand command = new DeleteFolderCommand(id);
            commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/list")
    public Response list(@QueryParam("userLogin") String login) throws Exception {
        try {
            ListFoldersCommand command = new ListFoldersCommand(login);
            ListFoldersResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getFolderDTOList())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }
}
