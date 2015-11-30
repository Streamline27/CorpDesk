package lv.javaguru.java3.core.commands.comment;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.commands.VoidResult;

/**
 * Created by svetlana on 28/11/15.
 */
public class DeleteCommentCommand implements DomainCommand<VoidResult> {

    private Long commentId;

    public DeleteCommentCommand(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentId() {
        return commentId;
    }
}
