package lv.javaguru.java3.rest.user;

import lv.javaguru.java3.core.dto.user.GroupDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface GroupResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/group")
    Response create(GroupDTO groupDTO) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/group")
    Response get(@QueryParam("groupId") Long groupId) throws Exception;

    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/group")
    Response delete(@QueryParam("groupId") Long groupId) throws Exception;

}