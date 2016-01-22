package lv.javaguru.java3.core.services.comment;

import lv.javaguru.java3.core.domain.comment.Comment;

import java.sql.Date;
import java.util.List;

/**
 * Created by svetlana on 28/11/15.
 */
public interface CommentService {

    Comment update(Long commentId,
                   Long newPostId,
                   Long newUserId,
                   String newText,
                   Date newPostedDate,
                   Date newModifiedDate);

    Comment get(Long commentId);

    List<Comment> getAll();

    void delete(Long commentId);
}
