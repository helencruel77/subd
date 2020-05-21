package subd.repository;

import subd.model.Event_program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventProgramRepository extends JpaRepository<Event_program, Integer> {
}
