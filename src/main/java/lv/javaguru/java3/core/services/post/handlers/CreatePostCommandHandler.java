package lv.javaguru.java3.core.services.post.handlers;

import lv.javaguru.java3.core.commands.post.CreatePostCommand;
import lv.javaguru.java3.core.commands.post.CreatePostResult;
import lv.javaguru.java3.core.convertor.PostConverter;
import lv.javaguru.java3.core.domain.post.Post;
import lv.javaguru.java3.core.dto.post.PostDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.post.PostFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by svetlana on 07/11/15.
 */
@Component
public class CreatePostCommandHandler implements DomainCommandHandler<CreatePostCommand, CreatePostResult> {

    @Autowired
    private PostFactory postFactory;
    @Autowired
    private PostConverter postConverter;

    @Override
    public CreatePostResult execute(CreatePostCommand command) throws Exception {
        Post post = postFactory.create(
                command.getUserId(),
                command.getGroupId(),
                command.getTitle(),
                command.getBody(),
                command.getCreatedDate(),
                command.getModifiedDate()
        );
        PostDTO postDTO = postConverter.convert(post);
        return new CreatePostResult(postDTO);
    }

    @Override
    public Class getCommandType() {
        return CreatePostCommand.class;
    }
}
