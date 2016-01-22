package lv.javaguru.java3.core.services.comment.handlers;

import lv.javaguru.java3.core.commands.comment.CreateCommentCommand;
import lv.javaguru.java3.core.commands.comment.CreateCommentResult;
import lv.javaguru.java3.core.convertor.CommentConverter;
import lv.javaguru.java3.core.domain.comment.Comment;
import lv.javaguru.java3.core.dto.comment.CommentDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.comment.CommentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by svetlana on 28/11/15.
 */
@Component
public class CreateCommentCommandHandler implements DomainCommandHandler<CreateCommentCommand, CreateCommentResult> {

    @Autowired
    private CommentFactory commentFactory;
    @Autowired
    private CommentConverter commentConverter;

    @Override
    public CreateCommentResult execute(CreateCommentCommand command) throws Exception {
        Comment comment = commentFactory.create(
                command.getPostId(),
                command.getUserId(),
                command.getText(),
                command.getPostedDate(),
                command.getModifiedDate()
        );
        CommentDTO commentDTO = commentConverter.convert(comment);
        return new CreateCommentResult(commentDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateCommentCommand.class;
    }
}
