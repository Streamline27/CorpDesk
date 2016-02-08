package lv.javaguru.java3.core.services.post;

import lv.javaguru.java3.core.domain.post.Post;

import java.sql.Date;
import java.util.List;

/**
 * Created by svetlana on 07/11/15.
 */
public interface PostService {

    Post update(Long postId,
                String newTitle,
                String newBody,
                Date modifiedDate);

    Post get(Long postId);

    List<Post> getAll();

    void delete(Long postId);
}
