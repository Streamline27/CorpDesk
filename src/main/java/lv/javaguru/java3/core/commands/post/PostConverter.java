package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.domain.post.Post;
import lv.javaguru.java3.core.dto.post.PostDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.dto.post.PostDTOBuilder.createPostDTO;

/**
 * Created by svetlana on 22/11/15.
 */

@Component
public class PostConverter {

    public PostDTO convert(Post post) {
        return createPostDTO()
                .withId(post.getId())
                .withUserId(post.getUserId())
                .withGroupId(post.getGroupId())
                .withTitle(post.getTitle())
                .withBody(post.getBody())
                .withCreatedDate(post.getCreatedDate())
                .withModifiedDate(post.getModifiedDate())
                .build();
    }

}
