package lv.javaguru.java3.core.services.post;

import org.junit.Test;

import java.sql.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by svetlana on 07/11/15.
 */
public class PostValidatorImplTest {

    private final PostValidator validator = new PostValidatorImpl();

    private static final Long POSTID = 1L;
    private static final Long USERID = 1L;
    private static final Long GROUPID = 1L;
    private static final String TITLE = "title";
    private static final String BODY = "body";
    private static final Date CREATEDDATE = new Date(System.currentTimeMillis());
    private static final Date MODIFIEDDATEFORCREATE = null;
    private static final Date MODIFIEDDATEFORUPDATE = new Date(System.currentTimeMillis() + 2);
    @Test
    public void validateForCreateShouldFailIfUserIdIsNull() {
        validateForCreateShouldFail(null,
                GROUPID,
                TITLE,
                BODY,
                CREATEDDATE,
                MODIFIEDDATEFORCREATE,
                "Post user id must not be null");
    }

    @Test
    public void validateForCreateShouldFailIfGroupIdIsNull() {
        validateForCreateShouldFail(USERID,
                null,
                TITLE,
                BODY,
                CREATEDDATE,
                MODIFIEDDATEFORCREATE,
                "Post group id must not be null");
    }

    @Test
    public void validateForCreateShouldFailIfTitleIsNull() {
        validateForCreateShouldFail(USERID,
                GROUPID,
                null,
                BODY,
                CREATEDDATE,
                MODIFIEDDATEFORCREATE,
                "Post title must not be null");
    }

    @Test
    public void validateForCreateShouldFailIfBodyIsNull() {
        validateForCreateShouldFail(USERID,
                GROUPID,
                TITLE,
                null,
                CREATEDDATE,
                MODIFIEDDATEFORCREATE,
                "Post body must not be null");
    }

    @Test
    public void validateForCreateShouldFailIfTitleIsEmpty() {
        validateForCreateShouldFail(USERID,
                GROUPID,
                "",
                BODY,
                CREATEDDATE,
                MODIFIEDDATEFORCREATE,
                "Post title must not be empty");
    }

    @Test
    public void validateForCreateShouldFailIfBodyIsEmpty() {
        validateForCreateShouldFail(USERID,
                GROUPID,
                TITLE,
                "",
                CREATEDDATE,
                MODIFIEDDATEFORCREATE,
                "Post body must not be empty");
    }

    @Test
    public void validateForCreateShouldFailIfCreatedDateIsNull() {
        validateForCreateShouldFail(USERID,
                GROUPID,
                TITLE,
                BODY,
                null,
                MODIFIEDDATEFORCREATE,
                "Post created date must not be null");
    }

    @Test
    public void validateForUpdateShouldFailIfPostIdIsNull() {
        validateForUpdateShouldFail(null,
                TITLE,
                BODY,
                MODIFIEDDATEFORUPDATE,
                "Post id must not be null");
    }

    @Test
    public void validateForUpdateShouldFailIfTitleIsNull() {
        validateForUpdateShouldFail(POSTID,
                null,
                BODY,
                MODIFIEDDATEFORUPDATE,
                "Post title must not be null");
    }

    @Test
    public void validateForUpdateShouldFailIfBodyIsNull() {
        validateForUpdateShouldFail(POSTID,
                TITLE,
                null,
                MODIFIEDDATEFORUPDATE,
                "Post body must not be null");
    }

    @Test
    public void validateForUpdateShouldFailIfTitleIsEmpty() {
        validateForUpdateShouldFail(POSTID,
                "",
                BODY,
                MODIFIEDDATEFORUPDATE,
                "Post title must not be empty");
    }

    @Test
    public void validateForUpdateShouldFailIfBodyIsEmpty() {
        validateForUpdateShouldFail(POSTID,
                TITLE,
                "",
                MODIFIEDDATEFORUPDATE,
                "Post body must not be empty");
    }

    @Test
    public void validateForUpdateShouldFailIfModifiedDateIsNull() {
        validateForUpdateShouldFail(POSTID,
                TITLE,
                BODY,
                null,
                "Updated post modified date must not be null");
    }

    private void validateForCreateShouldFail(Long userId,
                                             Long groupId,
                                             String title,
                                             String body,
                                             Date createdDate,
                                             Date modifiedDate,
                                             String errorMessage) {
        try {
            validator.validateForCreate(userId, groupId, title, body, createdDate, modifiedDate);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(errorMessage));
        }
    }

    private void validateForUpdateShouldFail(Long postId,
                                             String newTitle,
                                             String newBody,
                                             Date modifiedDate,
                                             String errorMessage) {
        try {
            validator.validateForUpdate(postId, newTitle, newBody, modifiedDate);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is(errorMessage));
        }
    }

}
