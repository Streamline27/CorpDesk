package lv.javaguru.java3.core.services.post;

import lv.javaguru.java3.core.domain.post.Post;

import java.sql.Date;

/**
 * Created by svetlana on 07/11/15.
 */
public interface PostFactory {

    Post create(Long userId,
                Long groupId,
                String title,
                String body,
                Date createdDate);
}
