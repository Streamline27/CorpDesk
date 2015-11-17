package lv.javaguru.java3.rest.user;

import lv.javaguru.java3.core.commands.user.command.*;
import lv.javaguru.java3.core.dto.user.UserDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Component
@Path("/user")
public class UserResourceImpl implements UserResource {

    private CommandExecutor commandExecutor;

    @Autowired
    public UserResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public UserDTO create(UserDTO userDTO) throws Exception {
        CreateUserCommand command = new CreateUserCommand(userDTO);
        CreateUserResult result = commandExecutor.execute(command);
        return result.getUserDTO();
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public List<UserDTO> get(@QueryParam("userId") Long userId) throws Exception {
        GetUserCommand command = new GetUserCommand(userId==null? 0 : userId);
        GetUserResult result = commandExecutor.execute(command);
        return result.getUserDTO();
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public UserDTO update(UserDTO userDTO) throws Exception {
        UpdateUserCommand command = new UpdateUserCommand(userDTO);
        UpdateUserResult result = commandExecutor.execute(command);
        return result.getUserDTO();
    }

    @Override
    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public void delete(@QueryParam("userId") Long userId) throws Exception {
        DeleteUserCommand command = new DeleteUserCommand(userId==null? 0 : userId);
        commandExecutor.execute(command);
    }
/*
    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public String authorize(UserDTO userDTO) throws Exception {
        return null;
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public String update(Long userId, GroupDTO groupDTO) throws Exception {
        return null;
    }
    */
}