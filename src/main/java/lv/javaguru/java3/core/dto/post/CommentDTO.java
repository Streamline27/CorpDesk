package lv.javaguru.java3.core.dto.post;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by svetlana on 16/11/15.
 */
public class CommentDTO implements Serializable {

    private Long id;
    private Long postId;
    private Long userId;
    private String text;
    private Date postedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }
}
