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
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

/**
 * Created by svetlana on 08/12/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class PostServiceImplTest {

    @Mock
    private PostValidator postValidator;

    @Mock
    private PostDAO postDAO;

    @InjectMocks
    private PostService postService = new PostServiceImpl();

    private static final Long POSTID = 1L;
    private static final Long USERID = 1L;
    private static final Long GROUPID = 1L;
    private static final String TITLE = "Title";
    private static final String BODY = "Body";
    private static final Date CREATEDDATE = new Date(System.currentTimeMillis());
    private static final String NEWTITLE = "NewTitle";
    private static final String NEWBODY = "NewBody";
    private static final Date MODIFIEDDATE = new Date(System.currentTimeMillis() + 2);

    @Test
    public void getShouldReturnPost() {
        when(postDAO.getRequired(POSTID)).thenReturn(createPostForTest());
        Post post = postService.get(POSTID);

        assertThat(post.getUserId(), is(USERID));
        assertThat(post.getGroupId(), is(GROUPID));
        assertThat(post.getTitle(), is(TITLE));
        assertThat(post.getBody(), is(BODY));
        assertThat(post.getCreatedDate(), is(CREATEDDATE));
        assertThat(post.getModifiedDate(), is(nullValue()));
    }

    @Test
    public void deleteShouldInvokeGetRequired() {
        when(postDAO.getRequired(POSTID)).thenReturn(createPostForTest());
        postService.delete(POSTID);
        verify(postDAO).getRequired(POSTID);
    }

    @Test
    public void deleteShouldInvokeDeleteFromDAO() {
        Post post = createPostForTest();
        when(postDAO.getRequired(POSTID)).thenReturn(post);
        postService.delete(POSTID);
        verify(postDAO).delete(post);
    }

    @Test
    public void updateShouldInvokeValidator() {
        when(postDAO.getRequired(POSTID)).thenReturn(createPostForTest());
        postService.update(POSTID, NEWTITLE, NEWBODY, MODIFIEDDATE);
        verify(postValidator).validateForUpdate(POSTID, NEWTITLE, NEWBODY, MODIFIEDDATE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void updateShouldFailIfValidateFail() {
        when(postDAO.getRequired(POSTID)).thenReturn(createPostForTest());
        doThrow(new IllegalArgumentException())
                .when(postValidator).validateForUpdate(POSTID, NEWTITLE, NEWBODY, MODIFIEDDATE);
        postService.update(POSTID, NEWTITLE, NEWBODY, MODIFIEDDATE);
    }

    @Test
    public void updateShouldPersistUpdatedPostAfterValidation() {
        Post post = createPostForTest();
		when(postDAO.getRequired(POSTID)).thenReturn(post);
        postService.update(POSTID, NEWTITLE, NEWBODY, MODIFIEDDATE);

        InOrder inOrder = inOrder(postValidator, postDAO);
        inOrder.verify(postValidator).validateForUpdate(POSTID, NEWTITLE, NEWBODY, MODIFIEDDATE);
        inOrder.verify(postDAO).getRequired(POSTID);
	}

    @Test
    public void updateShouldReturnUpdatedPost() {
        when(postDAO.getRequired(POSTID)).thenReturn(createPostForTest());
            Post post = postService.update(POSTID, NEWTITLE, NEWBODY, MODIFIEDDATE);

        assertThat(post.getTitle(), is(NEWTITLE));
        assertThat(post.getBody(), is(NEWBODY));
        assertThat(post.getModifiedDate(), is(MODIFIEDDATE));
    }

    private Post createPostForTest() {
        Post post = new Post();
        post.setUserId(USERID);
        post.setGroupId(GROUPID);
        post.setTitle(TITLE);
        post.setBody(BODY);
        post.setCreatedDate(CREATEDDATE);
        post.setModifiedDate(null);
        return post;
    }

}
