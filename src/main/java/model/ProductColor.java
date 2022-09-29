package model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "MauSac")
public class ProductColor {
    @Id
    @Column(name = "id")
    @GeneratedValue
    @UuidGenerator
    private String Id;

    @Column(name = "ma")
    private String Code;

    @Column(name="ten")
    private String Name;

    public ProductColor() {}

    public ProductColor(String code, String name) {
        Code = code;
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}