package lv.javaguru.java3.core.dto.user;

public class RoleDTOBuilder {

    private long id;
    private String name;
    
    private RoleDTOBuilder() {}

    public static RoleDTOBuilder createRoleDTO() { return new RoleDTOBuilder(); }

    public RoleDTO build() {

        RoleDTO roleDTO  = new RoleDTO();
        roleDTO.setId(id);
        roleDTO.setName(name);

        return roleDTO;

    }

    public RoleDTOBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public RoleDTOBuilder withName(String name) {
        this.name = name;
        return this;
    }
}
