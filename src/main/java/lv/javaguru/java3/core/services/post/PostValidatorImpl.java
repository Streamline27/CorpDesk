package lv.javaguru.java3.core.services.post;

import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * Created by svetlana on 07/11/15.
 */
@Component
public class PostValidatorImpl implements PostValidator {

    @Override
    public void validate(Long userId, Long groupId, String title, String body) {
        validateUserId(userId);
        validateGroupId(groupId);
        validateTitle(title);
        validateBody(body);
    }

    private void validateUserId(Long userId) {
        checkNotNull(userId, "Post user id must not be null");
    }

    private void validateGroupId(Long groupId) {
        checkNotNull(groupId, "Post group id must not be null");
    }

    private void validateTitle(String title) {
        checkNotNull(title, "Post title must not be null");
        checkArgument(!isBlank(title), "Post title must not be empty");
    }

    private void validateBody(String body) {
        checkNotNull(body, "Post body must not be null");
        checkArgument(!isBlank(body), "Post body must not be empty");
    }

}
