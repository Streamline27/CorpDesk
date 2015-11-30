package lv.javaguru.java3.core.convertor;

import lv.javaguru.java3.core.domain.post.Comment;
import lv.javaguru.java3.core.dto.post.CommentDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.dto.post.CommentDTOBuilder.createCommentDTO;

/**
 * Created by svetlana on 28/11/15.
 */

@Component
public class CommentConverter {

    public CommentDTO convert(Comment comment) {
        return createCommentDTO()
                .withId(comment.getId())
                .withPostId(comment.getPostId())
                .withUserId(comment.getUserId())
                .withText(comment.getText())
                .withPostedDate(comment.getPostedDate())
                .build();
    }

}
