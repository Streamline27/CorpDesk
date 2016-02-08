package lv.javaguru.java3.rest.comment;

import com.google.gson.Gson;
import lv.javaguru.java3.core.commands.comment.*;
import lv.javaguru.java3.core.dto.comment.CommentDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import lv.javaguru.java3.rest.comment.CommentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by svetlana on 08/12/15.
 */
@Component
@Path("/comments")
public class CommentResourceImpl implements CommentResource {

    private CommandExecutor commandExecutor;
    private Gson gson;

    @Autowired
    public CommentResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        this.gson = new Gson();
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(CommentDTO commentDTO) throws Exception {
        try {
            CreateCommentCommand command = new CreateCommentCommand(
                    commentDTO.getPostId(),
                    commentDTO.getUserId(),
                    commentDTO.getText(),
                    commentDTO.getPostedDate(),
                    commentDTO.getModifiedDate());
            CreateCommentResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getCommentDTO())).build();

        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response getAll() throws Exception {
        try {
            GetAllCommentsCommand command = new GetAllCommentsCommand();
            GetAllCommentsResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getCommentDTOs())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{commentId}")
    public Response get(@PathParam("commentId") Long commentId) throws Exception {
        try {
            GetCommentCommand command = new GetCommentCommand(commentId);
            GetCommentResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getCommentDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }
}
