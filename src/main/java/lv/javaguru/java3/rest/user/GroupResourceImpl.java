package lv.javaguru.java3.rest.user;

import com.google.gson.Gson;
import lv.javaguru.java3.core.commands.group.*;
import lv.javaguru.java3.core.dto.user.GroupDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Component
@Path("/group")
public class GroupResourceImpl implements GroupResource {

    private CommandExecutor commandExecutor;
    private Gson gson;

    @Autowired
    public GroupResourceImpl(CommandExecutor commandExecutor) {
        this.gson = new Gson();
        this.commandExecutor = commandExecutor;
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(GroupDTO groupDTO) throws Exception {
        try{
            CreateGroupCommand command = new CreateGroupCommand(groupDTO);
            CreateGroupResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getGroupDTO())).build();
        } catch (Exception e){
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response get(@QueryParam("groupId") Long groupId) throws Exception {
        try{
            GetGroupCommand command = new GetGroupCommand(groupId==null? 0 : groupId);
            GetGroupResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getGroupDTO())).build();
        } catch (Exception e){
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response delete(@QueryParam("groupId") Long groupId) throws Exception {
        try{
            DeleteGroupCommand command = new DeleteGroupCommand(groupId==null? 0 : groupId);
            commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e){
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }
}