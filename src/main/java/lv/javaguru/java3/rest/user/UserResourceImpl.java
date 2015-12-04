package lv.javaguru.java3.rest.user;

import com.google.gson.Gson;
import lv.javaguru.java3.core.commands.user.*;
import lv.javaguru.java3.core.dto.user.ChangePasswordDTO;
import lv.javaguru.java3.core.dto.user.UserDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Component
@Path("/user")
public class UserResourceImpl implements UserResource {

    private CommandExecutor commandExecutor;
    private Gson gson = new Gson();

    @Autowired
    public UserResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(UserDTO userDTO) throws Exception {
        try {
            CreateUserCommand command = new CreateUserCommand(userDTO);
            CreateUserResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getUserDTO())).build();
        } catch (Exception e){
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
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

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/changepassword")
    public Response changePassword(ChangePasswordDTO changePasswordDTO) throws Exception {
        try {
            ChangePasswordCommand command = new ChangePasswordCommand(changePasswordDTO);
            commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/validate")
    public int  authorize(UserDTO userDTO) throws Exception {
        AuthorizeUserCommand command = new AuthorizeUserCommand(userDTO);
        AuthorizeUserResult result = commandExecutor.execute(command);
        return result.getResponse();
    }

}