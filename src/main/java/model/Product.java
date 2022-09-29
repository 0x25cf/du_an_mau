package model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
@Entity
@Table(name="SanPham")
public class Product {
    @Id
    @Column(name="id")
    @GeneratedValue
    @UuidGenerator
    private String Id;

    @Column(name="ma")
    private String ProductId;

    @Column(name="ten")
    private String Name;

    public Product() {}

    public Product(String productId, String name) {
        ProductId = productId;
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
