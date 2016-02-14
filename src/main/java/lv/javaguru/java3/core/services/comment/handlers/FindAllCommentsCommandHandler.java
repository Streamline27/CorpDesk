package lv.javaguru.java3.core.services.comment.handlers;

import lv.javaguru.java3.core.commands.comment.FindAllCommentsCommand;
import lv.javaguru.java3.core.commands.comment.FindAllCommentsResult;
import lv.javaguru.java3.core.convertor.CommentConverter;
import lv.javaguru.java3.core.domain.comment.Comment;
import lv.javaguru.java3.core.dto.comment.CommentDTO;
import lv.javaguru.java3.core.services.DomainCommandHandler;
import lv.javaguru.java3.core.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by svetlana on 13/02/16.
 */
@Component
public class FindAllCommentsCommandHandler implements
        DomainCommandHandler<FindAllCommentsCommand, FindAllCommentsResult> {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentConverter commentConverter;

    @Override
    public FindAllCommentsResult execute(FindAllCommentsCommand command) throws Exception {
        List<Comment> commentList = commentService
                .findAllWithPagination(command.getPage(), command.getSize());
        List<CommentDTO> commentDTOList = commentConverter.convert(commentList);
        return new FindAllCommentsResult(commentDTOList);
    }

    @Override
    public Class getCommandType() {
        return FindAllCommentsCommand.class;
    }
}
