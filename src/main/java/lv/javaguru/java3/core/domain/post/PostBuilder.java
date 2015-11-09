package lv.javaguru.java3.core.domain.post;

import java.sql.Date;

/**
 * Created by svetlana on 31/10/15.
 */
public class PostBuilder {

    private Long id;
    private Long userId;
    private Long groupId;
    private String title;
    private String body;
    private Date createdDate;
    private Date modifiedDate;

    private PostBuilder() {

    }

    public static PostBuilder createPost() {
        return new PostBuilder();
    }

    public Post build() {
        Post post = new Post();
        post.setId(id);
        post.setUserId(userId);
        post.setGroupId(groupId);
        post.setTitle(title);
        post.setBody(body);
        post.setCreatedDate(createdDate);
        post.setModifiedDate(modifiedDate);
        return post;
    }

    public PostBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public PostBuilder withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public PostBuilder withGroupId(Long groupId) {
        this.groupId = groupId;
        return this;
    }

    public PostBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public PostBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public PostBuilder withCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PostBuilder withModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

}
