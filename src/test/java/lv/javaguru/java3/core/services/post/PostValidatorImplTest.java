package lv.javaguru.java3.core.services.post;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by svetlana on 07/11/15.
 */
public class PostValidatorImplTest {

    private final PostValidator validator = new PostValidatorImpl();

    private static final Long USERID = 1L;
    private static final Long GROUPID = 1L;
    private static final String TITLE = "title";
    private static final String BODY = "body";

    @Test
    public void validateShouldFailIfUserIdIsNull() {
        validateShouldFail(null, GROUPID, TITLE, BODY, "Post user id must not be null");
    }

    @Test
    public void validateShouldFailIfGroupIdIsNull() {
        validateShouldFail(USERID, null, TITLE, BODY, "Post group id must not be null");
    }

    @Test
    public void validateShouldFailIfTitleIsNull() {
        validateShouldFail(USERID, GROUPID, null, BODY, "Post title must not be null");
    }

    @Test
    public void validateShouldFailIfBodyIsNull() {
        validateShouldFail(USERID, GROUPID, TITLE, null, "Post body must not be null");
    }

    @Test
    public void validateShouldFailIfTitleIsEmpty() {
        validateShouldFail(USERID, GROUPID, "", BODY, "Post title must not be empty");
    }

    @Test
    public void validateShouldFailIfBodyIsEmpty() {
        validateShouldFail(USERID, GROUPID, TITLE, "", "Post body must not be empty");
    }

    private void validateShouldFail(Long userId,
                                    Long groupId,
                                    String title,
                                    String body,
                                    String errorMessage) {
        try {
            validator.validate(userId, groupId, title, body);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(errorMessage));
        }
    }

}
