package lv.javaguru.java3.core.database.post;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.posts.Post;
import org.junit.Test;

import javax.transaction.Transactional;
import java.sql.Date;

import static lv.javaguru.java3.core.domain.posts.PostBuilder.createPost;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by svetlana on 02/11/15.
 */
public class PostDAOImplTest extends DatabaseHibernateTest {

    private Date currentDate = new Date(System.currentTimeMillis());

    @Test
    @Transactional
    public void testCreatePost() {
        Post post = createPostForTest();
        assertThat(post.getId(), is(nullValue()));
        postDAO.create(post);
        assertThat(post.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testGetPostById() {
        Post post = createPostForTest();
        postDAO.create(post);
        Post postFromDB = postDAO.getById(post.getId());
        assertThat(postFromDB, is(notNullValue()));
    }

    @Test
    @Transactional
    public void testDeletePost() {
        Post post1 = createPostForTest();
        Post post2 = createPostForTest();
        postDAO.create(post1);
        postDAO.create(post2);
        assertThat(postDAO.getById(post1.getId()), is(notNullValue()));
        assertThat(postDAO.getById(post2.getId()), is(notNullValue()));
        postDAO.delete(post1);
        assertThat(postDAO.getById(post1.getId()), is(nullValue()));
        assertThat(postDAO.getById(post2.getId()), is(notNullValue()));
        postDAO.delete(post2);
        assertThat(postDAO.getById(post2.getId()), is(nullValue()));
    }

    private Post createPostForTest() {
        return createPost()
                .withUserId(1L)
                .withGroupId(1L)
                .withTitle("Title")
                .withBody("Body")
                .withCreatedDate(currentDate)
                .withModifiedDate(currentDate)
                .build();
    }
}
