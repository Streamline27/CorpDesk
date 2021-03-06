package lv.javaguru.java3.core.database.post;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.post.Post;
import org.junit.Test;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

import static lv.javaguru.java3.core.domain.post.PostBuilder.createPost;
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
        startTransaction();

        Post post = createPostForTest();
        assertThat(post.getId(), is(nullValue()));
        postDAO.create(post);
        assertThat(post.getId(), is(notNullValue()));

        postDAO.delete(post);

        commitTransaction();
    }

    @Test
    @Transactional
    public void testGetPostById() {
        startTransaction();

        Post post = createPostForTest();
        postDAO.create(post);
        Post postFromDB = postDAO.getById(post.getId());
        assertThat(postFromDB, is(notNullValue()));

        postDAO.delete(post);

        commitTransaction();
    }

    @Test
    @Transactional
    public void testUpdatePost() {
        startTransaction();

        Post post = createPostForTest();
        postDAO.create(post);

        Long newUserId = 2L;
        Long newGroupId = 2L;
        String newTitle = "New Title";
        String newBody = "New Body";
        Date newCreatedDate = new Date(System.currentTimeMillis() + 2);
        Date newModifiedDate = new Date(System.currentTimeMillis() + 2);

        post.setUserId(newUserId);
        post.setGroupId(newGroupId);
        post.setTitle(newTitle);
        post.setBody(newBody);
        post.setCreatedDate(newCreatedDate);
        post.setModifiedDate(newModifiedDate);

        Post postFromDB = postDAO.getById(post.getId());
        assertEquals(postFromDB.getUserId(), newUserId);
        assertEquals(postFromDB.getGroupId(), newGroupId);
        assertEquals(postFromDB.getTitle(), newTitle);
        assertEquals(postFromDB.getBody(), newBody);
        assertEquals(postFromDB.getCreatedDate(), newCreatedDate);
        assertEquals(postFromDB.getModifiedDate(), newModifiedDate);

        postDAO.delete(post);

        commitTransaction();
    }

    @Test
    @Transactional
    public void testDeletePost() {
        startTransaction();

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

        commitTransaction();
    }

    @Test
    @Transactional
    public void testFindAllPostsWithPagination() {
        startTransaction();

        Post post1 = createPostForTest();
        Post post2 = createPostForTest();
        Post post3 = createPostForTest();
        Post post4 = createPostForTest();

        postDAO.create(post1);
        postDAO.create(post2);
        postDAO.create(post3);
        postDAO.create(post4);

        List<Post> postList = postDAO.findAllWithPagination(2, 2);

        assertEquals(2, postList.size());

        postDAO.delete(post1);
        postDAO.delete(post2);
        postDAO.delete(post3);
        postDAO.delete(post4);

        commitTransaction();
    }

    private Post createPostForTest() {
        return createPost()
                .withUserId(1L)
                .withGroupId(1L)
                .withTitle("Title")
                .withBody("Body")
                .withCreatedDate(currentDate)
                .withModifiedDate(null)
                .build();
    }
}
