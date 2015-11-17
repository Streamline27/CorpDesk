package lv.javaguru.java3.core.commands.user.convertor;

import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.dto.user.UserDTOBuilder.createUserDTO;
import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;

@Component
public class UserConverter {

    @Autowired
    private RoleConverter roleConverter;
    @Autowired
    private StateConverter stateConverter;
    @Autowired
    private GroupConverter groupConverter;

    public UserDTO convert(User user) {
        if (user==null) return null;
        return createUserDTO()
                .withId(user.getId())
                .withLogin(user.getLogin())
                .withPassword(user.getPassword())
                .withUserRole(roleConverter.convert(user.getUserRole()))
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withEmail(user.getEmail())
                .withState(stateConverter.convert(user.getState()))
                .withGroups(groupConverter.convert(user.getGroups()))
                .build();
    }

    public List<UserDTO> convert(List<User> users) {
        List<UserDTO> result = new ArrayList<>();
        if (users!=null)
            for (User user: users)
                result.add(convert(user));
        return result;
    }

    public User convertDTO(UserDTO userDTO) {
        if (userDTO==null) return null;
        return createUser()
                .withId(userDTO.getId() == null? 0 : userDTO.getId())
                .withLogin(userDTO.getLogin())
                .withPassword(userDTO.getPassword())
                .withUserRole(roleConverter.convert(userDTO.getUserRole()))
                .withFirstName(userDTO.getFirstName())
                .withLastName(userDTO.getLastName())
                .withEmail(userDTO.getEmail())
                .withState(stateConverter.convert(userDTO.getState()))
                .withGroups(groupConverter.convertDTO(userDTO.getGroups()))
                .build();
    }

    public List<User> convertDTO(List<UserDTO> users) {
        List<User> result = new ArrayList<>();
        if (users!=null)
            for (UserDTO userDTO: users)
                result.add(convertDTO(userDTO));
        return result;
    }
}