package ai.tech.domain;

import ai.tech.domain.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;
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

  @Past private Timestamp birthday;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.MERGE)
  private List<Post> posts;

  @Builder
  public User(
      UUID uuid,
      Timestamp createdDate,
      Timestamp updatedDate,
      String createdBy,
      String updatedBy,
      String name,
      Timestamp birthday,
      List<Post> posts) {
    super(uuid, createdDate, updatedDate, createdBy, updatedBy);
    this.name = name;
    this.birthday = birthday;
    this.posts = posts;
  }

  @Builder
  public User(UUID uuid) {
    super(uuid);
  }
}
