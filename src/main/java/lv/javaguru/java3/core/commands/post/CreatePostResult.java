package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.domain.post.Post;

/**
 * Created by svetlana on 05/11/15.
 */
public class CreatePostResult implements DomainCommandResult {

    private Post post;

    public CreatePostResult(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
