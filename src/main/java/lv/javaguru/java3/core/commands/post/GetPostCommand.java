package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommand;

/**
 * Created by svetlana on 07/11/15.
 */
public class GetPostCommand implements DomainCommand<GetPostResult> {

    private Long postId;

    public GetPostCommand(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }
}
