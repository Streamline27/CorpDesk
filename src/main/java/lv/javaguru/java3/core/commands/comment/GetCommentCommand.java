package lv.javaguru.java3.core.commands.comment;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by svetlana on 28/11/15.
 */
public class GetCommentCommand implements DomainCommand<GetCommentResult> {

    private Long commentId;

    public GetCommentCommand(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentId() {
        return commentId;
    }
}
