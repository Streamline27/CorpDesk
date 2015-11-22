package lv.javaguru.java3.core.dto.post;

import java.sql.Date;

/**
 * Created by svetlana on 16/11/15.
 */
public class PostDTOBuilder {

    private Long id;
    private Long userId;
    private Long groupId;
    private String title;
    private String body;
    private Date createdDate;
    private Date modifiedDate;

    private PostDTOBuilder() {

    }

    public static PostDTOBuilder createPostDTO() {
        return new PostDTOBuilder();
    }

    public PostDTO build() {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(id);
        postDTO.setUserId(userId);
        postDTO.setGroupId(groupId);
        postDTO.setTitle(title);
        postDTO.setBody(body);
        postDTO.setCreatedDate(createdDate);
        postDTO.setModifiedDate(modifiedDate);
        return postDTO;
    }

    public PostDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public PostDTOBuilder withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public PostDTOBuilder withGroupId(Long groupId) {
        this.groupId = groupId;
        return this;
    }

    public PostDTOBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public PostDTOBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public PostDTOBuilder withCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public PostDTOBuilder withModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

}
