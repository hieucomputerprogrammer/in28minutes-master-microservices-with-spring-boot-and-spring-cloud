package ai.tech.domain;

import ai.tech.domain.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@JsonFilter(value = "UserFilter") // Dynamic filtering.
public class User extends BaseEntity {
  @Size(min = 2, message = "Name should contains at least 2 characters.")
  private String name;

  @Past private Date birthday;

  @Builder
  public User(UUID uuid, String name, Date birthday) {
    super(uuid);
    this.name = name;
    this.birthday = birthday;
  }
}
