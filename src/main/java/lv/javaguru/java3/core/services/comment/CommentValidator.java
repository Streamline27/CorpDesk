package lv.javaguru.java3.core.services.comment;

import java.sql.Date;

/**
 * Created by svetlana on 26/11/15.
 */
public interface CommentValidator {

    void validate(Long postId,
                  Long userId,
                  String text,
                  Date postedDate,
                  Date modifiedDate);
}
