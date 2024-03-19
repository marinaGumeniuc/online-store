package com.oline.store.dao.dto;

public class RoleDto {
private int id;
    private String roleName;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    @Override
    public String toString() {
        return "RoleDto [id=" + id + ", roleNmae=" + roleName + "]";
    }

}
