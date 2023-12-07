package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ticket_id")
    private UUID id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "thoi_gian_chieu")
    private LocalDate tGianChieu;
    @Column(name = "thoi_luong")
    private float thoiLuong;
    @Column(name = "price", nullable = false)
    private double price;
    //
    // JPA
    @ManyToOne
    @JoinColumn(name = "cus_id", nullable = false)
    private Customer customer;
    //


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate gettGianChieu() {
        return tGianChieu;
    }

    public void settGianChieu(LocalDate tGianChieu) {
        this.tGianChieu = tGianChieu;
    }

    public float getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(float thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ticket(UUID id, String title, LocalDate tGianChieu, float thoiLuong, double price) {
        this.id = id;
        this.title = title;
        this.tGianChieu = tGianChieu;
        this.thoiLuong = thoiLuong;
        this.price = price;
    }

    public Ticket() {
    }
}
