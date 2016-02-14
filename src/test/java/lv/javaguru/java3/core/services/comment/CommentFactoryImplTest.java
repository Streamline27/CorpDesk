package lv.javaguru.java3.core.services.comment;

import lv.javaguru.java3.core.database.comment.CommentDAO;
import lv.javaguru.java3.core.domain.comment.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

/**
 * Created by svetlana on 28/11/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class CommentFactoryImplTest {

    @Mock
    private CommentValidator commentValidator;
    @Mock
    private CommentDAO commentDAO;
    @InjectMocks
    private CommentFactory commentFactory = new CommentFactoryImpl();

    private static final Long POSTID = 1L;
    private static final Long USERID = 1L;
    private static final String TEXT = "Text";
    private static final Date POSTEDDATE = new Date(System.currentTimeMillis());
    private static final Date MODIFIEDDATE = null;

    @Test
    public void createShouldInvokeValidator() {
        commentFactory.create(POSTID, USERID, TEXT, POSTEDDATE, MODIFIEDDATE);
        verify(commentValidator).validate(POSTID, USERID, TEXT, POSTEDDATE, MODIFIEDDATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfValidatorFail() {
        doThrow(new IllegalArgumentException())
                .when(commentValidator).validate(POSTID, USERID, TEXT, POSTEDDATE, MODIFIEDDATE);
        commentFactory.create(POSTID, USERID, TEXT, POSTEDDATE, MODIFIEDDATE);
    }

    @Test
    public void createShouldPersistCommentAfterValidation() {
        Comment comment = commentFactory.create(POSTID, USERID, TEXT, POSTEDDATE, MODIFIEDDATE);
        InOrder inOrder = inOrder(commentValidator, commentDAO);
        inOrder.verify(commentValidator).validate(POSTID, USERID, TEXT, POSTEDDATE, MODIFIEDDATE);
        inOrder.verify(commentDAO).create(comment);
    }

    @Test
    public void createShouldReturnNewComment() {
        Comment comment = commentFactory.create(POSTID, USERID, TEXT, POSTEDDATE, MODIFIEDDATE);
        assertThat(comment.getPostId(), is(POSTID));
        assertThat(comment.getUserId(), is(USERID));
        assertThat(comment.getText(), is(TEXT));
        assertThat(comment.getPostedDate(), is(POSTEDDATE));
        assertThat(comment.getModifiedDate(), is(MODIFIEDDATE));
    }
}
