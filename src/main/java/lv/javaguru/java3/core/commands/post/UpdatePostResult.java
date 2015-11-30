package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.post.PostDTO;

/**
 * Created by svetlana on 07/11/15.
 */
public class UpdatePostResult implements DomainCommandResult {

    private PostDTO postDTO;

    public UpdatePostResult(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }
}
