package ai.tech.domain;

import ai.tech.domain.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@JsonFilter(value = "PostFilter")
public class Post extends BaseEntity {
  private String title;
  private String summary;
  private String content;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
  private User user;

  @Builder
  public Post(
      UUID uuid,
      Timestamp createdDate,
      Timestamp updatedDate,
      String createdBy,
      String updatedBy,
      String title,
      String summary,
      String content,
      User user) {
    super(uuid, createdDate, updatedDate, createdBy, updatedBy);
    this.title = title;
    this.summary = summary;
    this.content = content;
    this.user = user;
  }

  @Builder
  public Post(UUID uuid) {
    super(uuid);
  }
}
