package vn.amisoft.inventoryservice.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "t_inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String skuCode;

    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Inventory inventory = (Inventory) o;
        return id != null && Objects.equals(id, inventory.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}