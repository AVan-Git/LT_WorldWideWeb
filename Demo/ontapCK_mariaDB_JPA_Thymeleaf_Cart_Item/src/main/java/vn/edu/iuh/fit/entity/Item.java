package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "number_of")
    private int numberOf;
    @Column(name = "price")
    private double price;
    @Column(name = "sum_price")
    private double sumPrice;
    // JPA
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
    //

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOf=" + numberOf +
                ", price=" + price +
                ", sumPrice=" + sumPrice +
                '}';
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice() {
        this.sumPrice = this.price * this.numberOf;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Item(long id, String name, int numberOf, double price, Cart cart) {
        this.id = id;
        this.name = name;
        this.numberOf = numberOf;
        this.price = price;
        this.sumPrice = price * numberOf;
        this.cart = cart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Item() {
    }

    public Item(long id, String name, int numberOf, double price) {
        this.id = id;
        this.name = name;
        this.numberOf = numberOf;
        this.price = price;
        this.sumPrice = price * numberOf;
    }
}
