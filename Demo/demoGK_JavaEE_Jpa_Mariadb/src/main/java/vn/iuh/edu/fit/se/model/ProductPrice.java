package vn.iuh.edu.fit.se.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @Column(name = "price_date")
    private LocalDateTime priceDateTime;
    @Column(name = "note")
    private String note;
    @Column(name = "price", nullable = false)
    private double price;

    // jpa
    @ManyToOne
    @JoinColumn(name = "pro_id", nullable = false)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "priceDateTime=" + priceDateTime +
                ", note='" + note + '\'' +
                ", price=" + price +
                '}';
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductPrice() {
    }

    public ProductPrice(LocalDateTime priceDateTime, String note, double price) {
        this.priceDateTime = priceDateTime;
        this.note = note;
        this.price = price;
    }
}
