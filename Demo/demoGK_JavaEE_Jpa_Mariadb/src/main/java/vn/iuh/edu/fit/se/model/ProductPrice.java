package vn.iuh.edu.fit.se.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_date")
    private LocalDate priceDateTime;
    @Column(name = "note")
    private String note;
    @Column(name = "price", nullable = false)
    private double price;
}
