package lv.javaguru.java3.rest.user;

import lv.javaguru.java3.core.dto.user.ChangePasswordDTO;
import lv.javaguru.java3.core.dto.user.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface UserResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user")
    Response create(UserDTO userDTO) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user")
    Response get(@QueryParam("userId") Long userId) throws Exception;

    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user")
    Response update(UserDTO userDTO) throws Exception;

    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user")
    Response delete(@QueryParam("userId") Long userId) throws Exception;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user/changepassword")
    Response changePassword(ChangePasswordDTO changePasswordDTO) throws Exception;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/user/authorize")
    Response authorize(UserDTO userDTO) throws Exception;
}