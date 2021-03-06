package lv.javaguru.java3.rest.post;

import com.google.gson.Gson;
import lv.javaguru.java3.core.commands.post.*;
import lv.javaguru.java3.core.dto.post.PostDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by svetlana on 05/12/15.
 */
@Component
@Path("/posts")
public class PostResourceImpl implements PostResource {

    private CommandExecutor commandExecutor;
    private Gson gson;

    @Autowired
    public PostResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        this.gson = new Gson();
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(PostDTO postDTO) throws Exception {
        try {
            CreatePostCommand command = new CreatePostCommand(
                    postDTO.getUserId(),
                    postDTO.getGroupId(),
                    postDTO.getTitle(),
                    postDTO.getBody(),
                    postDTO.getCreatedDate(),
                    postDTO.getModifiedDate());
            CreatePostResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getPostDTO())).build();
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
            GetAllPostsCommand command = new GetAllPostsCommand();
            GetAllPostsResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getPostDTOs())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{postId}")
    public Response get(@PathParam("postId") Long postId) throws Exception {
        try {
            GetPostCommand command = new GetPostCommand(postId);
            GetPostResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getPostDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{page}&{size}")
    public Response findAll(@PathParam("page") int page,
                            @PathParam("size") int size) throws Exception {
        try {
            FindAllPostsCommand command = new FindAllPostsCommand(page, size);
            FindAllPostsResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getPostDTOList())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response update(PostDTO postDTO) throws Exception {
        try {
            UpdatePostCommand command = new UpdatePostCommand(postDTO.getId(),
                    postDTO.getTitle(),
                    postDTO.getBody(),
                    postDTO.getModifiedDate());
            UpdatePostResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getPostDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{postId}")
    public Response delete(@PathParam("postId")Long postId) throws Exception {
        try {
            DeletePostCommand command = new DeletePostCommand(postId);
            commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }
}
