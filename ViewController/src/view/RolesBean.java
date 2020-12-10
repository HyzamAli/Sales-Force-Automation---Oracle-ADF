package view;


public class RolesBean {
    private String roleName;
    private String roleDescription;
    private String rolesName;

    public RolesBean() {
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    public String getRolesName() {
        return rolesName;
    }
}
