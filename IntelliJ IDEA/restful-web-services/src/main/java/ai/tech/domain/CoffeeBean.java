package ai.tech.domain;

import ai.tech.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
public class CoffeeBean extends BaseEntity {
  private String name;
  private String color;
  private BigDecimal price;

  @Builder
  public CoffeeBean(UUID uuid, String name, String color, BigDecimal price) {
    super(uuid);
    this.name = name;
    this.color = color;
    this.price = price;
  }
}
