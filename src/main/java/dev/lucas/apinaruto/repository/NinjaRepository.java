package dev.lucas.apinaruto.repository;

import dev.lucas.apinaruto.model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<Ninja, Long> {
}
