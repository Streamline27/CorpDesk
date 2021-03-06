package lv.javaguru.java3.core.commands.comment;

import lv.javaguru.java3.core.commands.DomainCommand;

import java.sql.Date;

/**
 * Created by svetlana on 28/11/15.
 */
public class CreateCommentCommand implements DomainCommand<CreateCommentResult> {

    private Long postId;
    private Long userId;
    private String text;
    private Date postedDate;
    private Date modifiedDate;

    public CreateCommentCommand(Long postId,
                                Long userId,
                                String text,
                                Date postedDate,
                                Date modifiedDate) {
        this.postId = postId;
        this.userId = userId;
        this.text = text;
        this.postedDate = postedDate;
        this.modifiedDate = modifiedDate;
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

    public Date getModifiedDate() {
        return modifiedDate;
    }
}
