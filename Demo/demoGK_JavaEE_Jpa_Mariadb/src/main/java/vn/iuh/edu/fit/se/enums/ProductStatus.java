package vn.iuh.edu.fit.se.enums;

public enum ProductStatus {
    TERMINATE(-1),
    In_ACTIVE(0),
    ACTIVE(1);
    private int type;

    ProductStatus() {
    }

    public int getType() {
        return type;
    }

    ProductStatus(int type) {
        this.type = type;
    }
}
