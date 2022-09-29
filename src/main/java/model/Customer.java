package model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;

@Entity
@Table(name = "KhachHang")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column(name = "ma")
    private String CustomerId;

    @Column(name = "ten")
    private String Name;

    @Column(name = "TenDem")
    private String MidName;

    @Column(name = "Ho")
    private String LastName;

    @Column(name = "NgaySinh")
    private Date Birth;

    @Column(name = "Sdt")
    private String PhoneNumber;

    @Column(name = "DiaChi")
    private String Address;

    @Column(name = "ThanhPho")
    private String City;

    @Column(name = "QuocGia")
    private String Contry;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMidName() {
        return MidName;
    }

    public void setMidName(String midName) {
        MidName = midName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getBirth() {
        return Birth;
    }

    public void setBirth(Date birth) {
        Birth = birth;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getContry() {
        return Contry;
    }

    public void setContry(String contry) {
        Contry = contry;
    }
}
