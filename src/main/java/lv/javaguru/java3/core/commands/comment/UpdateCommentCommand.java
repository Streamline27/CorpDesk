package lv.javaguru.java3.core.commands.comment;

import lv.javaguru.java3.core.commands.DomainCommand;

import java.sql.Date;

/**
 * Created by svetlana on 28/11/15.
 */
public class UpdateCommentCommand implements DomainCommand<UpdateCommentResult> {

    private Long commentId;

    private Long postId;
    private Long userId;
    private String text;
    private Date postedDate;

    public UpdateCommentCommand(Long commentId,
                                Long postId,
                                Long userId,
                                String text,
                                Date postedDate) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.postedDate = postedDate;
    }

    public Long getCommentId() {
        return commentId;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public Date getPostedDate() {
        return postedDate;
    }
}
