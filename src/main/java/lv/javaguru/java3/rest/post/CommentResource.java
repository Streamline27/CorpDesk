package lv.javaguru.java3.rest.post;

import lv.javaguru.java3.core.dto.post.CommentDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by svetlana on 08/12/15.
 */
public interface CommentResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/comments")
    CommentDTO create(CommentDTO commentDTO) throws Exception;
}
