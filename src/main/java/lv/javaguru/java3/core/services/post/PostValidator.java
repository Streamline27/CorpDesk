package lv.javaguru.java3.core.services.post;

/**
 * Created by svetlana on 07/11/15.
 */
public interface PostValidator {

    void validate(Long userId, Long groupId, String title, String body);
}
