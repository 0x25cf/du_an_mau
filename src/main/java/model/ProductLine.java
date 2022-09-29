package model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name="DongSP")
public class ProductLine {
    @Id
    @Column(name="id")
    @GeneratedValue
    @UuidGenerator
    private String Id;

    @Column(name="ma")
    private String ProductLineId;

    @Column(name="ten")
    private String Name;

    public ProductLine() {}

    public ProductLine(String productLineId, String name) {
        ProductLineId = productLineId;
        Name = name;
    }

    public String getProductLineId() {
        return ProductLineId;
    }

    public void setProductLineId(String productLineId) {
        ProductLineId = productLineId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
