package lv.javaguru.java3.core.commands.comment;

import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by svetlana on 28/11/15.
 */
@Component
public class DeleteCommentCommandHandler implements DomainCommandHandler<DeleteCommentCommand, VoidResult> {

    @Autowired
    private CommentService commentService;

    @Override
    public VoidResult execute(DeleteCommentCommand command) throws Exception {
        commentService.delete(command.getCommentId());
        return VoidResult.INSTANCE;
    }

    @Override
    public Class getCommandType() {
        return VoidResult.class;
    }
}
