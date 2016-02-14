package lv.javaguru.java3.core.services.post;

import java.sql.Date;

/**
 * Created by svetlana on 07/11/15.
 */
public interface PostValidator {

    void validateForCreate(Long userId, Long groupId, String title, String body, Date createdDate, Date modifiedDate);

    void validateForUpdate(Long postId, String title, String body, Date modifiedDate);
}
