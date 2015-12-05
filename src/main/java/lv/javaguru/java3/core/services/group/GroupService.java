package lv.javaguru.java3.core.services.group;

import lv.javaguru.java3.core.domain.user.Group;

import java.util.List;


public interface GroupService {

    List<Group> getAll();

    void create(Group group) throws Exception;

    Group get(long groupId);

    void delete(long groupId);
}
