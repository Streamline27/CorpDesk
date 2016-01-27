package lv.javaguru.java3.core.database.post;

import lv.javaguru.java3.core.database.DatabaseHibernateTest;
import lv.javaguru.java3.core.domain.comment.Comment;
import org.junit.Test;

import javax.transaction.Transactional;
import java.sql.Date;

import static lv.javaguru.java3.core.domain.comment.CommentBuilder.createComment;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by svetlana on 02/11/15.
 */
public class CommentDAOImplTest extends DatabaseHibernateTest {

    private Date currentDate = new Date(System.currentTimeMillis());

    @Test
    @Transactional
    public void testCreatePost() {
        startTransaction();

        Comment comment = createCommentForTest();
        assertThat(comment.getId(), is(nullValue()));
        commentDAO.create(comment);
        assertThat(comment.getId(), is(notNullValue()));

        commentDAO.delete(comment);

        commitTransaction();
    }

    @Test
    @Transactional
    public void testGetCommentById() {
        startTransaction();

        Comment comment = createCommentForTest();
        commentDAO.create(comment);
        Comment commentFromDB = commentDAO.getById(comment.getId());
        assertThat(commentFromDB, is(notNullValue()));

        commentDAO.delete(comment);

        commitTransaction();
    }

    @Test
    @Transactional
    public void testUpdatePost() {
        startTransaction();

        Comment comment = createCommentForTest();
        commentDAO.create(comment);

        Long newPostId = 2L;
        Long newUserId = 2L;
        String newText = "New Text";
        Date newPostedDate = new Date(System.currentTimeMillis() + 2);
        Date newModifiedDate = new Date(System.currentTimeMillis() + 4);

        comment.setPostId(newPostId);
        comment.setUserId(newUserId);
        comment.setText(newText);
        comment.setPostedDate(newPostedDate);
        comment.setModifiedDate(newModifiedDate);

        Comment commentFromDB = commentDAO.getById(comment.getId());
        assertEquals(commentFromDB.getPostId(), newPostId);
        assertEquals(commentFromDB.getUserId(), newUserId);
        assertEquals(commentFromDB.getText(), newText);
        assertEquals(commentFromDB.getPostedDate(), newPostedDate);
        assertEquals(commentFromDB.getModifiedDate(), newModifiedDate);

        commentDAO.delete(comment);

        commitTransaction();
    }

    @Test
    @Transactional
    public void testDeleteComment() {
        startTransaction();

        Comment comment1 = createCommentForTest();
        Comment comment2 = createCommentForTest();
        commentDAO.create(comment1);
        commentDAO.create(comment2);
        assertThat(commentDAO.getById(comment1.getId()), is(notNullValue()));
        assertThat(commentDAO.getById(comment2.getId()), is(notNullValue()));
        commentDAO.delete(comment1);
        assertThat(commentDAO.getById(comment1.getId()), is(nullValue()));
        assertThat(commentDAO.getById(comment2.getId()), is(notNullValue()));
        commentDAO.delete(comment2);
        assertThat(commentDAO.getById(comment2.getId()), is(nullValue()));

        commitTransaction();
    }

    private Comment createCommentForTest() {
        return createComment()
                .withPostId(1L)
                .withUserId(1L)
                .withText("Text")
                .withPostedDate(currentDate)
                .withModifiedDate(null)
                .build();
    }

}
