package lv.javaguru.java3.core.convertor;

import lv.javaguru.java3.core.domain.post.Post;
import lv.javaguru.java3.core.dto.post.PostDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<PostDTO> convert(List<Post> posts) {
        List<PostDTO> result = new ArrayList<>();
        if(posts != null) {
            for (Post post : posts) {
                result.add(convert(post));
            }
        }
        return result;
    }
}
