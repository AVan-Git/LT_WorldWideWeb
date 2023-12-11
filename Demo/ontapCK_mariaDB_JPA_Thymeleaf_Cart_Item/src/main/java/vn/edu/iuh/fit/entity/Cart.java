package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;
    @Column(name = "id_user")
    private String idUser;
    @Column(name = "date_add")
    private LocalDate dateAdd;
    @Column(name = "date_update")
    private LocalDate dateUpdate;
    // JPA
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Item> items;
    //


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", idUser='" + idUser + '\'' +
                ", dateAdd=" + dateAdd +
                ", dateUpdate=" + dateUpdate +
                ", items=" + items +
                '}';
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Cart(long id, String idUser, LocalDate dateAdd, LocalDate dateUpdate, List<Item> items) {
        this.id = id;
        this.idUser = idUser;
        this.dateAdd = dateAdd;
        this.dateUpdate = dateUpdate;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public LocalDate getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(LocalDate dateAdd) {
        this.dateAdd = dateAdd;
    }

    public LocalDate getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDate dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Cart() {
    }

    public Cart(long id, String idUser, LocalDate dateAdd, LocalDate dateUpdate) {
        this.id = id;
        this.idUser = idUser;
        this.dateAdd = dateAdd;
        this.dateUpdate = dateUpdate;
    }
}
