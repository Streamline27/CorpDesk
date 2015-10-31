package lv.javaguru.java3.core.domain.user;

public class RoleBuilder {

    private long id;
    private String name;

    private RoleBuilder() {}

    public static RoleBuilder createRole() { return new RoleBuilder(); }

    public Role build() {

        Role role  = new Role();
        role.setId(id);
        role.setName(name);

        return role;

    }
    public RoleBuilder admin() {
        this.id = 1;
        return this;
    }

    public RoleBuilder user() {
        this.id = 2;
        return this;
    }


}
