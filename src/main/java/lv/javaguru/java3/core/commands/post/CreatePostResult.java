package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.post.PostDTO;

/**
 * Created by svetlana on 05/11/15.
 */
public class CreatePostResult implements DomainCommandResult {

    private PostDTO postDTO;

    public CreatePostResult(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }
}
