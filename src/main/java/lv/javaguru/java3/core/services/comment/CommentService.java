package lv.javaguru.java3.core.services.comment;

import lv.javaguru.java3.core.domain.post.Comment;

import java.sql.Date;

/**
 * Created by svetlana on 28/11/15.
 */
public interface CommentService {

    Comment update(Long commentId,
                   Long newPostId,
                   Long newUserId,
                   String newText,
                   Date newPostedDate);

    Comment get(Long commentId);

    void delete(Long commentId);
}
