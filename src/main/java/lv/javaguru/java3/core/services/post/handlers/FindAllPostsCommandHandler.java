package lv.javaguru.java3.core.services.post.handlers;

import lv.javaguru.java3.core.commands.post.FindAllPostsCommand;
import lv.javaguru.java3.core.commands.post.FindAllPostsResult;
import lv.javaguru.java3.core.convertor.PostConverter;
import lv.javaguru.java3.core.domain.post.Post;
import lv.javaguru.java3.core.dto.post.PostDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by svetlana on 13/02/16.
 */
@Component
public class FindAllPostsCommandHandler implements
        DomainCommandHandler<FindAllPostsCommand, FindAllPostsResult> {

    @Autowired
    private PostService postService;
    @Autowired
    private PostConverter postConverter;

    @Override
    public FindAllPostsResult execute(FindAllPostsCommand command) throws Exception {
        List<Post> postList = postService
                .findAllWithPagination(command.getPage(), command.getSize());
        List<PostDTO> postDTOList = postConverter.convert(postList);
        return new FindAllPostsResult(postDTOList);
    }

    @Override
    public Class getCommandType() {
        return FindAllPostsCommand.class;
    }
}
