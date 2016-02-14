package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommand;

import java.sql.Date;

/**
 * Created by svetlana on 07/11/15.
 */
public class UpdatePostCommand implements DomainCommand<UpdatePostResult> {

    private Long postId;

    private String title;
    private String body;
    private Date modifiedDate;

    public UpdatePostCommand(Long postId,
                             String title,
                             String body,
                             Date modifiedDate){
        this.postId = postId;
        this.title = title;
        this.body = body;
        this.modifiedDate = modifiedDate;
    }

    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }
}
