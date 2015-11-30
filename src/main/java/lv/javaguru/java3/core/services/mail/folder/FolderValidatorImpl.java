package lv.javaguru.java3.core.services.mail.folder;

import lv.javaguru.java3.core.domain.mail.Folder;
import lv.javaguru.java3.core.domain.mail.FolderCategory;
import lv.javaguru.java3.core.domain.user.User;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * Created by Andrew on 21.11.2015.
 */
@Component
public class FolderValidatorImpl implements FolderValidator {

    @Override
    public void validate(Folder folder) {
        validateUser(folder.getUserId());
        validateName(folder.getName());
        validateCategory(folder.getCategory());
    }

    private void validateUser(long userId) {
        checkArgument(userId > 0, "User ID must be greater than zero");
    }

    private void validateName(String name) {
        checkNotNull(name, "Folder name must not be null");
        checkArgument(isNotBlank(name), "Folder must not be blank");
    }

    private void validateCategory(FolderCategory category) {
        checkNotNull(category, "Folder category must not be null");
        checkArgument(category.getId() > 0, "Folder category ID must be greater than zero");
    }

}
