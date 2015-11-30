package lv.javaguru.java3.rest.user;

import lv.javaguru.java3.core.commands.group.*;
import lv.javaguru.java3.core.dto.user.GroupDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Component
@Path("/group")
public class GroupResourceImpl implements GroupResource {

    private CommandExecutor commandExecutor;

    @Autowired
    public GroupResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public GroupDTO create(GroupDTO groupDTO) throws Exception {
        CreateGroupCommand command = new CreateGroupCommand(groupDTO);
        CreateGroupResult result = commandExecutor.execute(command);
        return result.getGroupDTO();
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public List<GroupDTO> get(@QueryParam("groupId") Long groupId) throws Exception {
        GetGroupCommand command = new GetGroupCommand(groupId==null? 0 : groupId);
        GetGroupResult result = commandExecutor.execute(command);
        return result.getGroupDTO();
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public GroupDTO update(GroupDTO groupDTO) throws Exception {
        UpdateGroupCommand command = new UpdateGroupCommand(groupDTO);
        UpdateGroupResult result = commandExecutor.execute(command);
        return result.getGroupDTO();
    }

    @Override
    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public void delete(@QueryParam("groupId") Long groupId) throws Exception {
        DeleteGroupCommand command = new DeleteGroupCommand(groupId==null? 0 : groupId);
        commandExecutor.execute(command);
    }
}