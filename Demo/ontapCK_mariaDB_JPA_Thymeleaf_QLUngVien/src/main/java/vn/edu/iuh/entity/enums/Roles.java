package vn.edu.iuh.entity.enums;

public enum Roles {

    ADMINISTRATION(1),
    STAFF(2),
    MANAGER(3),
    EXECUTIVE(4);
    private int role;

    public int getRole() {
        return role;
    }

    Roles(int role) {
        this.role = role;
    }
}
