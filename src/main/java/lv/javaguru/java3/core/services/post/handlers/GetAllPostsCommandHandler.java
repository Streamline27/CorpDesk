package lv.javaguru.java3.core.services.post.handlers;

import lv.javaguru.java3.core.commands.post.GetAllPostsCommand;
import lv.javaguru.java3.core.commands.post.GetAllPostsResult;
import lv.javaguru.java3.core.convertor.PostConverter;
import lv.javaguru.java3.core.domain.post.Post;
import lv.javaguru.java3.core.dto.post.PostDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by svetlana on 01/01/16.
 */
@Component
public class GetAllPostsCommandHandler implements DomainCommandHandler<GetAllPostsCommand, GetAllPostsResult> {

    @Autowired
    private PostService postService;
    @Autowired
    private PostConverter postConverter;

    @Override
    public GetAllPostsResult execute(GetAllPostsCommand command) throws Exception {
        List<Post> posts = postService.getAll();
        List<PostDTO> postDTOs = postConverter.convert(posts);
        return new GetAllPostsResult(postDTOs);
    }

    @Override
    public Class getCommandType() {
        return GetAllPostsCommand.class;
    }
}
