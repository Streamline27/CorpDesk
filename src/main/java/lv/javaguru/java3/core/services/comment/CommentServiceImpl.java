package lv.javaguru.java3.core.services.comment;

import lv.javaguru.java3.core.database.comment.CommentDAO;
import lv.javaguru.java3.core.domain.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * Created by svetlana on 28/11/15.
 */
@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private CommentValidator commentValidator;

    @Override
    public Comment update(Long commentId,
                          Long newPostId,
                          Long newUserId,
                          String newText,
                          Date newPostedDate,
                          Date newModifiedDate) {
        commentValidator.validate(newPostId, newUserId, newText, newPostedDate, newModifiedDate);
        Comment comment = get(commentId);
        comment.setPostId(newPostId);
        comment.setUserId(newUserId);
        comment.setText(newText);
        comment.setPostedDate(newPostedDate);
        comment.setModifiedDate(newModifiedDate);
        return comment;
    }

    @Override
    public Comment get(Long commentId) {
        return commentDAO.getRequired(commentId);
    }

    @Override
    public List<Comment> getAll() {
        return commentDAO.getAll();
    }

    @Override
    public void delete(Long commentId) {
        Comment comment = get(commentId);
        commentDAO.delete(comment);
    }
}
