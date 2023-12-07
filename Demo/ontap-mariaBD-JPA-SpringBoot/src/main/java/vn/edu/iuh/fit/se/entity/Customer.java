package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "khach_hang")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "address")
    private String address;
    @Column(name = "so_ve")
    private int soVe;
    //
    // JPA
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
    //

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSoVe() {
        return soVe;
    }

    public void setSoVe(int soVe) {
        this.soVe = soVe;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Customer() {
    }

    public Customer(UUID id, String name, int age, String address, int soVe) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.soVe = soVe;
    }
}
