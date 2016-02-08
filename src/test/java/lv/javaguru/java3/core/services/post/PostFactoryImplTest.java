package lv.javaguru.java3.core.services.post;

import lv.javaguru.java3.core.database.post.PostDAO;
import lv.javaguru.java3.core.domain.post.Post;
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
 * Created by svetlana on 07/11/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class PostFactoryImplTest {

    @Mock
    private PostValidator postValidator;
    @Mock
    private PostDAO postDAO;

    @InjectMocks
    private PostFactory postFactory = new PostFactoryImpl();

    private static final Long USERID = 1L;
    private static final Long GROUPID = 1L;
    private static final String TITLE = "title";
    private static final String BODY = "body";
    private static final Date CREATEDDATE = new Date(System.currentTimeMillis());
    private static final Date MODIFIEDDATE = null;

    @Test
    public void createShouldInvokeValidator() {
        postFactory.create(USERID, GROUPID, TITLE, BODY, CREATEDDATE, MODIFIEDDATE);
        verify(postValidator).validateForCreate(USERID, GROUPID, TITLE, BODY, CREATEDDATE, MODIFIEDDATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShouldFailIfValidateFail() {
        doThrow(new IllegalArgumentException())
                .when(postValidator).validateForCreate(USERID, GROUPID, TITLE, BODY, CREATEDDATE, MODIFIEDDATE);
        postFactory.create(USERID, GROUPID, TITLE, BODY, CREATEDDATE, MODIFIEDDATE);
    }

    @Test
    public void createShouldPersistPostAfterValidation() {
        Post post = postFactory.create(USERID, GROUPID, TITLE, BODY, CREATEDDATE, MODIFIEDDATE);
        InOrder inOrder = inOrder(postValidator, postDAO);
        inOrder.verify(postValidator).validateForCreate(USERID, GROUPID, TITLE, BODY, CREATEDDATE, MODIFIEDDATE);
        inOrder.verify(postDAO).create(post);
    }

    @Test
    public void createShouldReturnNewPost() {
        Post post = postFactory.create(USERID, GROUPID, TITLE, BODY, CREATEDDATE, MODIFIEDDATE);
        assertThat(post.getUserId(), is(USERID));
        assertThat(post.getGroupId(), is(GROUPID));
        assertThat(post.getTitle(), is(TITLE));
        assertThat(post.getBody(), is(BODY));
        assertThat(post.getCreatedDate(),is(CREATEDDATE));
        assertThat(post.getModifiedDate(), is(MODIFIEDDATE));
    }

}
