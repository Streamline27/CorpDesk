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
    private Date modifiedDate;

    public CreatePostCommand(Long userId,
                             Long groupId,
                             String title,
                             String body,
                             Date createdDate,
                             Date modifiedDate) {
        this.userId = userId;
        this.groupId = groupId;
        this.title = title;
        this.body = body;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
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

    public Date getModifiedDate() {
        return modifiedDate;
    }
}
