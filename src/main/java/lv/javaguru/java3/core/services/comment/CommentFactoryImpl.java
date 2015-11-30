package lv.javaguru.java3.core.services.comment;

import lv.javaguru.java3.core.database.post.CommentDAO;
import lv.javaguru.java3.core.domain.post.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

import static lv.javaguru.java3.core.domain.post.CommentBuilder.createComment;

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
    public Comment create(Long postId, Long userId, String text, Date postedDate) {
        commentValidator.validate(postId, userId, text, postedDate);
        Comment comment = createComment()
                .withPostId(postId)
                .withUserId(userId)
                .withText(text)
                .withPostedDate(postedDate)
                .build();
        commentDAO.create(comment);
        return comment;
    }
}
