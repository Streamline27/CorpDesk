package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommandResult;
import lv.javaguru.java3.core.domain.post.Post;

/**
 * Created by svetlana on 07/11/15.
 */
public class GetPostResult implements DomainCommandResult {

    private Post post;

    public GetPostResult(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
