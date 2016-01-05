package lv.javaguru.java3.core.dto.comment;

import java.sql.Date;

/**
 * Created by svetlana on 17/11/15.
 */
public class CommentDTOBuilder {

    private Long id;
    private Long postId;
    private Long userId;
    private String text;
    private Date postedDate;

    private CommentDTOBuilder() {

    }

    public static CommentDTOBuilder createCommentDTO() {
        return new CommentDTOBuilder();
    }

    public CommentDTO build() {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(id);
        commentDTO.setPostId(postId);
        commentDTO.setUserId(userId);
        commentDTO.setText(text);
        commentDTO.setPostedDate(postedDate);
        return commentDTO;
    }

    public CommentDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CommentDTOBuilder withPostId(Long postId) {
        this.postId = postId;
        return this;
    }

    public CommentDTOBuilder withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public CommentDTOBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public CommentDTOBuilder withPostedDate(Date postedDate) {
        this.postedDate = postedDate;
        return this;
    }

}
