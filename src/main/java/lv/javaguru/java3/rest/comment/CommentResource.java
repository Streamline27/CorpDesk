package lv.javaguru.java3.rest.comment;

import lv.javaguru.java3.core.dto.comment.CommentDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by svetlana on 08/12/15.
 */
public interface CommentResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/comments")
    Response create(CommentDTO commentDTO) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/comments")
    Response getAll() throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/comments/{commentId}")
    Response get(@PathParam("commentId") Long commentId) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/comments/{page}&{size}")
    Response findAll(@PathParam("page") int page, @PathParam("size") int size) throws Exception;
}
