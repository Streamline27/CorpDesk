package lv.javaguru.java3.core.commands.post;

import lv.javaguru.java3.core.commands.DomainCommand;

import java.sql.Date;

/**
 * Created by svetlana on 05/11/15.
 */
public class CreatePostCommand implements DomainCommand<CreatePostResult> {

    private Long userId;
    private Long groupId;
    private String title;
    private String body;
    private Date createdDate;

    public CreatePostCommand(Long userId,
                             Long groupId,
                             String title,
                             String body,
                             Date createdDate) {
        this.userId = userId;
        this.groupId = groupId;
        this.title = title;
        this.body = body;
        this.createdDate = createdDate;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
