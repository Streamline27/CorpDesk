package lv.javaguru.java3.core.convertor;

import lv.javaguru.java3.core.domain.user.Role;
import lv.javaguru.java3.core.dto.user.RoleDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.dto.user.RoleDTOBuilder.createRoleDTO;
import static lv.javaguru.java3.core.domain.user.RoleBuilder.createRole;

@Component
public class RoleConverter {

    public RoleDTO convert(Role role) {
        if (role==null) return null;
        return createRoleDTO()
                .withId(role.getId())
                .withName(role.getName())
                .build();
    }

    public Role convert(RoleDTO roleDTO) {
        if (roleDTO==null) return null;
        return createRole()
                .withId(roleDTO.getId())
                .withName(roleDTO.getName())
                .build();
    }
}