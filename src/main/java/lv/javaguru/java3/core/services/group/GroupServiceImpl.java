package lv.javaguru.java3.core.services.group;

import lv.javaguru.java3.core.database.user.GroupDAO;
import lv.javaguru.java3.core.domain.user.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class GroupServiceImpl implements GroupService {

    private final GroupDAO groupDAO;
    private GroupValidator groupValidator;

    @Autowired
    public GroupServiceImpl(GroupDAO groupDAO, GroupValidator groupValidator) {
        this.groupDAO = groupDAO;
        this.groupValidator = groupValidator;
    }

    @Override
    public List<Group> getAll() {
        return groupDAO.getAll();
    }

    @Override
    public void create(Group group) throws Exception {
        groupValidator.validate(group);
        groupDAO.create(group);
    }

    @Override
    public void update(Group group) throws Exception {
        groupValidator.validate(group);
        groupDAO.update(group);
    }

    @Override
    public Group get(long groupId) {
        return groupDAO.getById(groupId);
    }

    @Override
    public void delete(long groupId) {
        Group group = groupDAO.getRequired(groupId);
        groupDAO.delete(group);
    }
}
