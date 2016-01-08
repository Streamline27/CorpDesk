package lv.javaguru.java3.core.services.comment.handlers;

import lv.javaguru.java3.core.commands.comment.GetCommentCommand;
import lv.javaguru.java3.core.commands.comment.GetCommentResult;
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
public class GetCommentCommandHandler implements DomainCommandHandler<GetCommentCommand, GetCommentResult> {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentConverter commentConverter;

    @Override
    public GetCommentResult execute(GetCommentCommand command) throws Exception {
        Comment comment = commentService.get(command.getCommentId());
        CommentDTO commentDTO = commentConverter.convert(comment);
        return new GetCommentResult(commentDTO);
    }

    @Override
    public Class getCommandType() {
        return GetCommentCommand.class;
    }
}
