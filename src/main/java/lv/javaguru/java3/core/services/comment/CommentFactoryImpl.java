package lv.javaguru.java3.core.services.comment;

import lv.javaguru.java3.core.database.comment.CommentDAO;
import lv.javaguru.java3.core.domain.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

import static lv.javaguru.java3.core.domain.comment.CommentBuilder.createComment;

/**
 * Created by svetlana on 26/11/15.
 */
@Component
public class CommentFactoryImpl implements CommentFactory {

    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private CommentValidator commentValidator;

    @Override
    public Comment create(Long postId,
                          Long userId,
                          String text,
                          Date postedDate,
                          Date modifiedDate) {
        commentValidator.validate(postId, userId, text, postedDate, modifiedDate);
        Comment comment = createComment()
                .withPostId(postId)
                .withUserId(userId)
                .withText(text)
                .withPostedDate(postedDate)
                .withModifiedDate(modifiedDate)
                .build();
        commentDAO.create(comment);
        return comment;
    }
}
