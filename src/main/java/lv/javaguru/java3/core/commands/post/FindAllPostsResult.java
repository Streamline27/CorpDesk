package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.dto.post.PostDTO;

import java.util.List;

/**
 * Created by svetlana on 13/02/16.
 */
public class FindAllPostsResult implements DomainCommandResult {

    private List<PostDTO> postDTOList;

    public FindAllPostsResult(List<PostDTO> postDTOList) {
        this.postDTOList = postDTOList;
    }

    public List<PostDTO> getPostDTOList() {
        return postDTOList;
    }
}
