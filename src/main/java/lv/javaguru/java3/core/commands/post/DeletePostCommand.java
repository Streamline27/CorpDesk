package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.commands.VoidResult;

/**
 * Created by svetlana on 09/11/15.
 */
public class DeletePostCommand implements DomainCommand<VoidResult> {

    private Long postId;

    public DeletePostCommand(Long postId) {
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }
}
