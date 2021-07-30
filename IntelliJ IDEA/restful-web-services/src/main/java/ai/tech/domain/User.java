package ai.tech.domain;

import ai.tech.domain.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class User extends BaseEntity {
    private String name;
    private Date birthday;

    @Builder
    public User(UUID uuid, String name, Date birthday) {
        super(uuid);
        this.name = name;
        this.birthday = birthday;
    }
}