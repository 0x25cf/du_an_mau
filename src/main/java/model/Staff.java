package model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Date;

@Entity
@Table(name="NhanVien")
public class Staff {
    @Id
    @Column(name="id")
    @GeneratedValue
    @UuidGenerator
    private String Id;

    @Column(name="ma")
    private String StaffId;

    @Column(name="ten")
    private String Mame;

    @Column(name = "tendem")
    private String MidName;

    @Column(name = "ho")
    private String LastName;

    @Column(name = "GioiTinh")
    private String gender;

    @Column(name = "NgaySinh")
    private Date Birth;

    @Column(name = "DiaChi")
    private String DiaChi;

    @Column(name = "Sdt")
    private String PhoneNumber;

    @Column(name = "MatKhau")
    private String Password;

    @Column(name = "IdCH")
    private String StoreId;

    @Column(name = "IdCV")
    private String Position;

    @Column(name = "IdGuiBC")
    private String GuiBC;

    @Column(name = "TrangThai")
    private Integer Status;

    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String staffId) {
        StaffId = staffId;
    }

    public String getMame() {
        return Mame;
    }

    public void setMame(String mame) {
        Mame = mame;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return Birth;
    }

    public void setBirth(Date birth) {
        Birth = birth;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getStoreId() {
        return StoreId;
    }

    public void setStoreId(String storeId) {
        StoreId = storeId;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getGuiBC() {
        return GuiBC;
    }

    public void setGuiBC(String guiBC) {
        GuiBC = guiBC;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }
}
