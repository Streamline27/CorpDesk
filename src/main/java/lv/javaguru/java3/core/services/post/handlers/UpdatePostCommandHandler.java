package lv.javaguru.java3.core.services.post.handlers;

import lv.javaguru.java3.core.commands.post.UpdatePostCommand;
import lv.javaguru.java3.core.commands.post.UpdatePostResult;
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
public class UpdatePostCommandHandler implements DomainCommandHandler<UpdatePostCommand, UpdatePostResult> {

    @Autowired
    private PostService postService;
    @Autowired
    private PostConverter postConverter;

    @Override
    public UpdatePostResult execute(UpdatePostCommand command) throws Exception {
        Post post = postService.update(
                command.getPostId(),
                command.getUserId(),
                command.getGroupId(),
                command.getTitle(),
                command.getBody(),
                command.getModifiedDate());
        PostDTO postDTO = postConverter.convert(post);
        return new UpdatePostResult(postDTO);
    }

    @Override
    public Class getCommandType() {
        return UpdatePostCommand.class;
    }
}
