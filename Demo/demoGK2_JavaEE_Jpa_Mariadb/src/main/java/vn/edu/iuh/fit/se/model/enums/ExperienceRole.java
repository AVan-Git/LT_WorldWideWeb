package vn.edu.iuh.fit.se.model.enums;

public enum ExperienceRole {
    ADMINISTRATION(1),
    STAFF(2),
    MANAGER(3),
    EXECUTIVE(4);
    private int role;

    public int getRole() {
        return role;
    }

    ExperienceRole(int role) {
        this.role = role;
    }
}
