package lv.javaguru.java3.core.services.comment;

import org.junit.Test;

import java.sql.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by svetlana on 28/11/15.
 */
public class CommentValidatorImplTest {

    private final CommentValidator validator = new CommentValidatorImpl();

    private static final Long POSTID = 1L;
    private static final Long USERID = 1L;
    private static final String TEXT = "Text";
    private static final Date POSTEDDATE = new Date(System.currentTimeMillis());

    @Test
    public void validateShouldFailIfPostIdIsNull(){
        validateShouldFail(null, USERID, TEXT, POSTEDDATE, "Comment post id must not be null");
    }

    @Test
    public void validateShouldFailIfUserIdIsNull() {
        validateShouldFail(POSTID, null, TEXT, POSTEDDATE, "Comment user id must not be null");
    }

    @Test
    public void validateShouldFailIfTextIsNull() {
        validateShouldFail(POSTID, USERID, null, POSTEDDATE, "Comment text must not be null");
    }

    @Test
    public void validateShouldFailIfPostedDateIsNull() {
        validateShouldFail(POSTID, USERID, TEXT, null, "Comment posted date must not be null");
    }

    @Test
    public void validateShouldFailIfTextIsEmpty() {
        validateShouldFail(POSTID, USERID, "", POSTEDDATE, "Comment text must not be empty");
    }

    private void validateShouldFail(Long postId,
                                    Long userId,
                                    String text,
                                    Date postedDate,
                                    String errorMessage) {
        try {
            validator.validate(postId, userId, text, postedDate);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(errorMessage));
        }
    }

}
