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

    @Override
    public Post update(Long postId, Long newUserId, Long newGroupId, String newTitle, String newBody, Date modifiedDate) {
        return null;
    }

    @Override
    public Post get(Long postId) {
        return postDAO.getRequired(postId);
    }
}
