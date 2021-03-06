package lv.javaguru.java3.core.commands.comment;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.comment.CommentDTO;

/**
 * Created by svetlana on 28/11/15.
 */
public class UpdateCommentResult implements DomainCommandResult {

    private CommentDTO commentDTO;

    public UpdateCommentResult(CommentDTO commentDTO) {
        this.commentDTO = commentDTO;
    }

    public CommentDTO getCommentDTO() {
        return commentDTO;
    }
}
