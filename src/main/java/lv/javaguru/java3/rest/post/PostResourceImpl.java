package lv.javaguru.java3.rest.post;

import lv.javaguru.java3.core.commands.post.CreatePostCommand;
import lv.javaguru.java3.core.commands.post.CreatePostResult;
import lv.javaguru.java3.core.dto.post.PostDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by svetlana on 05/12/15.
 */
@Component
@Path("/posts")
public class PostResourceImpl implements PostResource {

    private CommandExecutor commandExecutor;

    @Autowired
    public PostResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public PostDTO create(PostDTO postDTO) throws Exception {
        CreatePostCommand command = new CreatePostCommand(
                postDTO.getUserId(),
                postDTO.getGroupId(),
                postDTO.getTitle(),
                postDTO.getBody(),
                postDTO.getCreatedDate());
        CreatePostResult result = commandExecutor.execute(command);
        return result.getPostDTO();
    }
}
