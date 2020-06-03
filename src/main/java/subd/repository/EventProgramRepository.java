package subd.repository;

import subd.model.EventProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventProgramRepository extends JpaRepository<EventProgram, Integer> {
}
