package lv.javaguru.java3.core.services.mail.message;

import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * Created by Andrew on 17.11.2015.
 */
@Component
public class MessageValidatorImpl implements MessageValidator {

    @Autowired private UserDAO userDAO;

    @Override
    public void validate(User sender,
                         String title,
                         String body,
                         List<User> recipients,
                         boolean isImportant) {

        validateSender(sender);
        validateTitle(title);
        validateBody(body);
        validateRecipients(recipients);
        validateIsImportant(isImportant);

    }

    private void validateSender(User sender) {
        checkNotNull(sender, "Message sender not must be null");
        checkNotNull(userDAO.getById(sender.getId()), "Message sender must have a valid user");
    }

    private void validateTitle(String title) {
        checkNotNull(title, "Message title must not be null");
        checkArgument(isNotBlank(title), "Message title must not be blank");
    }

    private void validateBody(String body) {
        checkNotNull(body, "Message body not must be null");
    }

    private void validateRecipients(List<User> recipients) {
        checkNotNull(recipients, "Recipient list must not be null");
        checkArgument(!recipients.isEmpty(), "Recipient list must not be empty");
        for (User r : recipients)
            checkNotNull(userDAO.getById(r.getId()), "Message recipient must be a valid users");
    }

    private void validateIsImportant(boolean isImportant) {
    }

}
