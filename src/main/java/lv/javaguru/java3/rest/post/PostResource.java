package lv.javaguru.java3.rest.post;

import lv.javaguru.java3.core.dto.post.PostDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by svetlana on 05/12/15.
 */
public interface PostResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/posts")
    PostDTO create(PostDTO postDTO) throws Exception;

}
