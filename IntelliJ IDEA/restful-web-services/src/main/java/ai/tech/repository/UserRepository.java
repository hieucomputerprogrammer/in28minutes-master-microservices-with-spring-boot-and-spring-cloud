package ai.tech.repository;

import ai.tech.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    private static List<User> users = new ArrayList<User>();

    static {
        users.add(User.builder().uuid(UUID.randomUUID()).name("Hieu").birthday(new Date(1994, 7, 13)).build());
        users.add(User.builder().uuid(UUID.randomUUID()).name("James Gosling").birthday(new Date(1955, 5, 19)).build());
        users.add(User.builder().uuid(UUID.randomUUID()).name("Guido Van Rossum").birthday(new Date(1956, 1, 31)).build());
    }

    public User save(User user) {
        user.setUuid(UUID.randomUUID());
        users.add(user);

        return user;
    }

    public List<User> findAll() {
        return this.users;
    }

    public User findById(UUID uuid) {
        for (User user : this.users)
            return user.getUuid().equals(uuid) ? user : null;

        return null;
    }

    public void deleteById(UUID uuid) {
        for (User user : this.users)
            if (user.getUuid().equals(uuid))
                this.users.remove(this.findById(uuid));
    }
}