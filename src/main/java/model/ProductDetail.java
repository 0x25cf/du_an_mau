package model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;
@Entity
@Table(name="ChiTietSP")
public class ProductDetail {
    @Id
    @Column(name="id")
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column(name = "IdSP")
    private String ProductId;

    @Column(name = "IdMauSac")
    private String ProductColorId;

    @Column(name = "IdNSX")
    private String ProducerId;

    @Column(name = "IdDongSP")
    private String ProductLineId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="IdSP", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductColor color;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNSX", referencedColumnName = "id", insertable = false, updatable = false)
    private Producer producer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductLine product_line;

    public ProductDetail() {}

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductColorId() {
        return ProductColorId;
    }

    public void setProductColorId(String productColorId) {
        ProductColorId = productColorId;
    }

    public String getProducerId() {
        return ProducerId;
    }

    public void setProducerId(String producerId) {
        ProducerId = producerId;
    }

    public String getProductLineId() {
        return ProductLineId;
    }

    public void setProductLineId(String productLineId) {
        ProductLineId = productLineId;
    }

    public ProductDetail(String productId, String productColorId, String producerId, String productLineId) {
        ProductId = productId;
        ProductColorId = productColorId;
        ProducerId = producerId;
        ProductLineId = productLineId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public ProductLine getProduct_line() {
        return product_line;
    }

    public void setProduct_line(ProductLine product_line) {
        this.product_line = product_line;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductColor getColor() {
        return color;
    }

    public void setColor(ProductColor color) {
        this.color = color;
    }

    public String[] toStrings() {
        // {"ma", "ten", "mau", "nha san xuat", "dong san pham"},
        return new String[] {
            this.product.getProductId(),
            this.product.getName(),
            this.color.getName(),
            this.producer.getName(),
            this.product_line.getName()
        };
    }
}
