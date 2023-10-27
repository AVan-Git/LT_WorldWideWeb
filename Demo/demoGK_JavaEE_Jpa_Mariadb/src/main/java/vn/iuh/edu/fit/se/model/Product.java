package vn.iuh.edu.fit.se.model;

import jakarta.persistence.*;
import vn.iuh.edu.fit.se.enums.ProductStatus;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private long id;
    @Column(name = "pro_name", nullable = false, length = 100)
    private String name;
    @Column(name = "pro_des")
    private String description;
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    @Column(name = "unit")
    private String unit;
    @Column(name = "status")
    private ProductStatus status;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", unit='" + unit + '\'' +
                ", status=" + status +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getUnit() {
        return unit;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public Product() {
    }

    public Product(long id, String name, String description, String manufacturerName, String unit, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manufacturerName = manufacturerName;
        this.unit = unit;
        this.status = status;
    }
}
