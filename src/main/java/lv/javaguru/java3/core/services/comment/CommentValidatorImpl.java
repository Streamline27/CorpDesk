package lv.javaguru.java3.core.services.comment;

import org.springframework.stereotype.Component;

import java.sql.Date;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * Created by svetlana on 26/11/15.
 */
@Component
public class CommentValidatorImpl implements CommentValidator {

    @Override
    public void validate(Long postId, Long userId, String text, Date postedDate, Date modifiedDate) {
        validatePostId(postId);
        validateUserId(userId);
        validateText(text);
        validatePostedDate(postedDate);
        validateModifiedDate(modifiedDate);
    }

    private void validatePostId(Long postId) {
        checkNotNull(postId, "Comment post id must not be null");
    }

    private void validateUserId(Long userId){
        checkNotNull(userId, "Comment user id must not be null");
    }

    private void validateText(String text){
        checkNotNull(text, "Comment text must not be null");
        checkArgument(!isBlank(text), "Comment text must not be empty");
    }

    private void validatePostedDate(Date postedDate) {
        checkNotNull(postedDate, "Comment posted date must not be null");
    }

    private void validateModifiedDate(Date modifiedDate) {

    }
}
