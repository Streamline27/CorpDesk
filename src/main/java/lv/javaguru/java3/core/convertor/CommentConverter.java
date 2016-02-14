package lv.javaguru.java3.core.convertor;

import lv.javaguru.java3.core.domain.comment.Comment;
import lv.javaguru.java3.core.dto.comment.CommentDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.dto.comment.CommentDTOBuilder.createCommentDTO;

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
                .withModifiedDate(comment.getModifiedDate())
                .build();
    }

    public List<CommentDTO> convert(List<Comment> comments) {
        List<CommentDTO> result = new ArrayList<>();
        if(comments != null) {
            for(Comment comment : comments) {
                result.add(convert(comment));
            }
        }
        return result;
    }

}
