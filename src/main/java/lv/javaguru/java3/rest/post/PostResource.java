package lv.javaguru.java3.rest.post;

import lv.javaguru.java3.core.dto.post.PostDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by svetlana on 05/12/15.
 */
public interface PostResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/posts")
    Response create(PostDTO postDTO) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/posts")
    Response getAll() throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/posts/{postId}")
    Response get(@PathParam("postId") Long postId) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/posts/{page}&{size}")
    Response findAll(@PathParam("page") int page, @PathParam("size") int size) throws Exception;

    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/posts")
    Response update(PostDTO postDTO) throws Exception;

    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/posts/{postId}")
    Response delete(@PathParam("postId") Long postId) throws Exception;

}
