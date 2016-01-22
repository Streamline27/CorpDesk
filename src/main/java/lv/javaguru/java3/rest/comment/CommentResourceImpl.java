package lv.javaguru.java3.rest.comment;

import lv.javaguru.java3.core.commands.comment.CreateCommentCommand;
import lv.javaguru.java3.core.commands.comment.CreateCommentResult;
import lv.javaguru.java3.core.dto.comment.CommentDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import lv.javaguru.java3.rest.comment.CommentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by svetlana on 08/12/15.
 */
@Component
@Path("/comments")
public class CommentResourceImpl implements CommentResource {

    private CommandExecutor commandExecutor;

    @Autowired
    public CommentResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public CommentDTO create(CommentDTO commentDTO) throws Exception {
        CreateCommentCommand command = new CreateCommentCommand(
                commentDTO.getPostId(),
                commentDTO.getUserId(),
                commentDTO.getText(),
                commentDTO.getPostedDate(),
                commentDTO.getModifiedDate());
        CreateCommentResult result = commandExecutor.execute(command);
        return result.getCommentDTO();
    }
}
