package lv.javaguru.java3.core.services.comment.handlers;

import lv.javaguru.java3.core.commands.comment.GetAllCommentsCommand;
import lv.javaguru.java3.core.commands.comment.GetAllCommentsResult;
import lv.javaguru.java3.core.convertor.CommentConverter;
import lv.javaguru.java3.core.domain.comment.Comment;
import lv.javaguru.java3.core.dto.comment.CommentDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by svetlana on 05/01/16.
 */
@Component
public class GetAllCommentsCommandHandler implements DomainCommandHandler<GetAllCommentsCommand, GetAllCommentsResult> {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentConverter commentConverter;

    @Override
    public GetAllCommentsResult execute(GetAllCommentsCommand command) throws Exception {
        List<Comment> comments = commentService.getAll();
        List<CommentDTO> commentDTOs = commentConverter.convert(comments);
        return new GetAllCommentsResult(commentDTOs);
    }

    @Override
    public Class getCommandType() {
        return GetAllCommentsCommand.class;
    }
}
