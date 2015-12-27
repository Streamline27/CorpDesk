package lv.javaguru.java3.core.services.post;

import lv.javaguru.java3.core.database.post.PostDAO;
import lv.javaguru.java3.core.domain.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by svetlana on 07/11/15.
 */
@Component
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDAO postDAO;
    @Autowired
    private PostValidator postValidator;

    @Override
    public Post update(Long postId,
                       Long newUserId,
                       Long newGroupId,
                       String newTitle,
                       String newBody,
                       Date modifiedDate) {
        postValidator.validate(newUserId, newGroupId, newTitle, newBody);
        Post post = get(postId);
        post.setUserId(newUserId);
        post.setGroupId(newGroupId);
        post.setTitle(newTitle);
        post.setBody(newBody);
        post.setModifiedDate(modifiedDate);
        return post;
    }

    @Override
    public Post get(Long postId) {
        return postDAO.getRequired(postId);
    }

    @Override
    public void delete(Long postId) {
        Post post = get(postId);
        postDAO.delete(post);
    }
}
