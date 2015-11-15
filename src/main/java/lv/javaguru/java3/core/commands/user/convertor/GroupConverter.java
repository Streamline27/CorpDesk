package lv.javaguru.java3.core.commands.user.convertor;

import lv.javaguru.java3.core.domain.user.Group;
import lv.javaguru.java3.core.dto.user.GroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.dto.user.GroupDTOBuilder.createGroupDTO;
import static lv.javaguru.java3.core.domain.user.GroupBuilder.createGroup;

@Component
public class GroupConverter {
    @Autowired
    private StateConverter stateConverter;

    public GroupDTO convert(Group group) {
        if (group==null) return null;
        return createGroupDTO()
                .withId(group.getId())
                .withName(group.getName())
                .withState(stateConverter.convert(group.getState()))
                .withLastModified(group.getLastModified())
                .build();
    }

    public List<GroupDTO> convert(List<Group> groups) {
        List<GroupDTO> result = new ArrayList<>();
        if (groups!=null)
            for (Group group: groups)
                result.add(convert(group));
        return result;
    }

    public Group convertDTO(GroupDTO groupDTO) {
        if (groupDTO==null) return null;
        return createGroup()
                .withId(groupDTO.getId())
                .withName(groupDTO.getName())
                .withState(stateConverter.convert(groupDTO.getState()))
                .withLastModified(groupDTO.getLastModified())
                .build();
    }

    public List<Group> convertDTO(List<GroupDTO> groupDTOs) {
        List<Group> result = new ArrayList<>();
        if (groupDTOs!=null)
            for (GroupDTO groupDTO: groupDTOs)
                result.add(convertDTO(groupDTO));
        return result;
    }

}