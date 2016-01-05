package lv.javaguru.java3.core.commands.comment;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.comment.CommentDTO;

import java.util.List;

/**
 * Created by svetlana on 05/01/16.
 */
public class GetAllCommentsResult implements DomainCommandResult {

    private List<CommentDTO> commentDTOs;

    public GetAllCommentsResult(List<CommentDTO> commentDTOs) {
        this.commentDTOs = commentDTOs;
    }

    public List<CommentDTO> getCommentDTOs() {
        return commentDTOs;
    }

}
