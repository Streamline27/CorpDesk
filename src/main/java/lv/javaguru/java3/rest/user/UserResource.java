package lv.javaguru.java3.rest.user;

import lv.javaguru.java3.core.dto.user.ChangePasswordDTO;
import lv.javaguru.java3.core.dto.user.UserDTO;

import javax.ws.rs.*;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface UserResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user")
    UserDTO create(UserDTO userDTO) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user")
    List<UserDTO> get(@QueryParam("userId") Long userId) throws Exception;

    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user")
    UserDTO update(UserDTO userDTO) throws Exception;

    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user")
    void delete(@QueryParam("userId") Long userId) throws Exception;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user/changepassword")
    int changePassword(ChangePasswordDTO changePasswordDTO) throws Exception;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user/validate")
    int authorize(UserDTO userDTO) throws Exception;

    /*
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user/group/{userId}")
    String update(@PathParam("userId") Long userId,GroupDTO groupDTO) throws Exception;
    */
}