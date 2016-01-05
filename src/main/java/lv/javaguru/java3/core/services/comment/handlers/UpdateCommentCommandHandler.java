package lv.javaguru.java3.core.services.comment.handlers;

import lv.javaguru.java3.core.commands.comment.UpdateCommentCommand;
import lv.javaguru.java3.core.commands.comment.UpdateCommentResult;
import lv.javaguru.java3.core.convertor.CommentConverter;
import lv.javaguru.java3.core.domain.comment.Comment;
import lv.javaguru.java3.core.dto.comment.CommentDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by svetlana on 28/11/15.
 */
@Component
public class UpdateCommentCommandHandler implements DomainCommandHandler<UpdateCommentCommand, UpdateCommentResult> {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentConverter commentConverter;

    @Override
    public UpdateCommentResult execute(UpdateCommentCommand command) throws Exception {
        Comment comment = commentService.update(
                command.getCommentId(),
                command.getPostId(),
                command.getUserId(),
                command.getText(),
                command.getPostedDate());
        CommentDTO commentDTO = commentConverter.convert(comment);
        return new UpdateCommentResult(commentDTO);
    }

    @Override
    public Class getCommandType() {
        return UpdateCommentCommand.class;
    }
}
