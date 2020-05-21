package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
}
