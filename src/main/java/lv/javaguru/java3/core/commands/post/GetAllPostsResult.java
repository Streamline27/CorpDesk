package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.post.PostDTO;

import java.util.List;

/**
 * Created by svetlana on 01/01/16.
 */
public class GetAllPostsResult implements DomainCommandResult {

    private List<PostDTO> postDTOs;

    public GetAllPostsResult(List<PostDTO> postDTOs) {
        this.postDTOs = postDTOs;
    }

    public List<PostDTO> getPostDTOs() {
        return postDTOs;
    }
}
