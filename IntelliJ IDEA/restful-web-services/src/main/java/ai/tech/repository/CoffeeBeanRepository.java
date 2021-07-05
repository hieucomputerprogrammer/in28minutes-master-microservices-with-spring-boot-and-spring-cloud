package ai.tech.repository;

import ai.tech.domain.CoffeeBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoffeeBeanRepository extends JpaRepository<CoffeeBean, UUID> {
}