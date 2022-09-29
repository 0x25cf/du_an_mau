package model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "NSX")
public class Producer {
    @Id
    @Column(name = "id")
    @GeneratedValue
    @UuidGenerator
    private String Id;

    @Column(name = "ma")
    private String ProducerId;

    @Column(name="ten")
    private String Name;

    public Producer() {}

    public Producer(String producerId, String name) {
        ProducerId = producerId;
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProducerId() {
        return ProducerId;
    }

    public void setProducerId(String producerId) {
        ProducerId = producerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
