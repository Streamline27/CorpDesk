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

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Component
@Path("/user")
public class UserResourceImpl implements UserResource {

    private CommandExecutor commandExecutor;
    private Gson gson;

    @Autowired
    public UserResourceImpl(CommandExecutor commandExecutor) {
        this.gson = new Gson();
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
    public Response get(@QueryParam("userId") Long userId) throws Exception {
        try {
            GetUserCommand command = new GetUserCommand(userId == null ? 0 : userId);
            GetUserResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getUserDTO())).build();
        } catch (Exception e){
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response update(UserDTO userDTO) throws Exception {
        try {
            UpdateUserCommand command = new UpdateUserCommand(userDTO);
            UpdateUserResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getUserDTO())).build();
        } catch (Exception e){
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response delete(@QueryParam("userId") Long userId) throws Exception {
        try {
            DeleteUserCommand command = new DeleteUserCommand(userId==null? 0 : userId);
            commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e){
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
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
    @Path("/authorize")
    public Response authorize(UserDTO userDTO) throws Exception {
        try {
            AuthorizeUserCommand command = new AuthorizeUserCommand(userDTO);
            commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }
}