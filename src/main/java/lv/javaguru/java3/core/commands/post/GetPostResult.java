package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.post.PostDTO;

/**
 * Created by svetlana on 07/11/15.
 */
public class GetPostResult implements DomainCommandResult {

    private PostDTO postDTO;

    public GetPostResult(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }
}
