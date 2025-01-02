package brandkon;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int price;
    private int expirationDays;
    private String imageUrl;

    @ManyToOne
    private Brand brand;

    public Product(long id, String name, int price, int expirationDays, String imageUrl,Brand brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expirationDays = expirationDays;
        this.imageUrl = imageUrl;
        this.brand = brand;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getExpirationDays() {
        return expirationDays;
    }

    public Brand getBrand() {
        return brand;
    }
}
