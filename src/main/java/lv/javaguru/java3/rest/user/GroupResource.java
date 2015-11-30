package lv.javaguru.java3.rest.user;

import lv.javaguru.java3.core.dto.user.GroupDTO;

import javax.ws.rs.*;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface GroupResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/group")
    GroupDTO create(GroupDTO groupDTO) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/group")
    List<GroupDTO> get(@QueryParam("groupId") Long groupId) throws Exception;

    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/group")
    GroupDTO update(GroupDTO groupDTO) throws Exception;

    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/group")
    void delete(@QueryParam("groupId") Long groupId) throws Exception;

}