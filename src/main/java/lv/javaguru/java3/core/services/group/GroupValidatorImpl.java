package lv.javaguru.java3.core.services.group;

import lv.javaguru.java3.core.database.user.GroupDAO;
import lv.javaguru.java3.core.domain.user.Group;
import lv.javaguru.java3.core.services.group.exception.GroupAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang.StringUtils.isBlank;

@Component
class GroupValidatorImpl implements GroupValidator {

    @Autowired
    private GroupDAO groupDAO;

    @Override
    public void validate(Group group, Boolean mustExist) throws Exception {
        validateGroup(group);
        validateName(group.getName());

        if (!mustExist && groupDAO.getByName(group.getName())!=null){
            throw new GroupAlreadyExistException();
        }
    }

    private void validateGroup(Group group) {
        checkNotNull(group, String.format("Group fields must be not empty"));
    }

    private void validateName(String name) {
        notNull(name, "name");
    }

    private void notNull(String field, String name){
        checkNotNull(field, String.format("Group %s must not be null", name));
        checkArgument(!isBlank(field), String.format("Group %s must not be empty", name));
    }

}
