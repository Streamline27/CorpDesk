package lv.javaguru.java3.core.services.post;

import lv.javaguru.java3.core.database.post.PostDAO;
import lv.javaguru.java3.core.domain.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

import static lv.javaguru.java3.core.domain.post.PostBuilder.createPost;

/**
 * Created by svetlana on 07/11/15.
 */
@Component
public class PostFactoryImpl implements PostFactory {

    @Autowired
    private PostDAO postDAO;
    @Autowired
    private PostValidator postValidator;

    @Override
    public Post create(Long userId,
                       Long groupId,
                       String title,
                       String body,
                       Date createdDate,
                       Date modifiedDate) {
        postValidator.validateForCreate(userId, groupId, title, body, createdDate, modifiedDate);
        Post post = createPost().withUserId(userId)
                .withGroupId(groupId)
                .withTitle(title)
                .withBody(body)
                .withCreatedDate(createdDate)
                .withModifiedDate(modifiedDate)
                .build();
        postDAO.create(post);
        return post;
    }
}
