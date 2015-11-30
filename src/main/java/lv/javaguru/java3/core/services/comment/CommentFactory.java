package lv.javaguru.java3.core.services.comment;

import lv.javaguru.java3.core.domain.post.Comment;

import java.sql.Date;

/**
 * Created by svetlana on 26/11/15.
 */
public interface CommentFactory {

    Comment create(Long postId,
                   Long userId,
                   String text,
                   Date postedDate);
}
