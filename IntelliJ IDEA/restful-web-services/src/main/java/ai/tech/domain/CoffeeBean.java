package ai.tech.domain;

import ai.tech.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CoffeeBean extends BaseEntity implements Serializable {
    private String name;
    private String color;
    private BigDecimal price;

    public CoffeeBean(UUID id, String name, String color, BigDecimal price) {
        super(id);
        this.name = name;
        this.color = color;
        this.price = price;
    }
}