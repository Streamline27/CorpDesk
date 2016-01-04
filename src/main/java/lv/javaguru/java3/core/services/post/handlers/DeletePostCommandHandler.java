package lv.javaguru.java3.core.services.post.handlers;

import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.commands.post.DeletePostCommand;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by svetlana on 09/11/15.
 */
@Component
public class DeletePostCommandHandler implements DomainCommandHandler<DeletePostCommand, VoidResult> {

    @Autowired
    private PostService postService;

    @Override
    public VoidResult execute(DeletePostCommand command) throws Exception {
        postService.delete(command.getPostId());
        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return VoidResult.class;
    }
}
