package ovh.jakubk.keno.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ovh.jakubk.keno.model.KenoDraw;

import java.util.Optional;

@Repository
public interface KenoDrawDAO extends JpaRepository<KenoDraw, Long> {
    Optional<KenoDraw> findFirstByOrderByIdDesc();
}
