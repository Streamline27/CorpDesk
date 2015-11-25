package lv.javaguru.java3.core.services.group;

import lv.javaguru.java3.core.domain.user.Group;

public interface GroupValidator {

    void validate(Group group) throws Exception;
}
