package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.convertor.PostConverter;
import lv.javaguru.java3.core.domain.post.Post;
import lv.javaguru.java3.core.dto.post.PostDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by svetlana on 08/11/15.
 */
@Component
public class GetPostCommandHandler implements DomainCommandHandler<GetPostCommand, GetPostResult> {

    @Autowired
    private PostService postService;
    @Autowired
    private PostConverter postConverter;

    @Override
    public GetPostResult execute(GetPostCommand command) throws Exception {
        Post post = postService.get(command.getPostId());
        PostDTO postDTO = postConverter.convert(post);
        return new GetPostResult(postDTO);
    }

    @Override
    public Class getCommandType() {
        return GetPostCommand.class;
    }
}
