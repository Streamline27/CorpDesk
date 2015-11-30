package lv.javaguru.java3.core.services.group;

import lv.javaguru.java3.core.domain.user.Group;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

@Component
class GroupValidatorImpl implements GroupValidator {

    @Override
    public void validate(Group group) throws Exception {
        validateName(group.getName());
    }

    private void validateName(String name) {
        notNull(name, "name");
    }

    private void notNull(String field, String name){
        checkNotNull(field, String.format("Group %s must not be null", name));
        checkArgument(!isBlank(field), String.format("Group %s must not be empty", name));
    }

}
