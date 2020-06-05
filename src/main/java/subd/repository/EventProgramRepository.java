package subd.repository;

import subd.model.EventProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventProgramRepository extends JpaRepository<EventProgram, Integer> {
    List<EventProgram> getAllByNameEquals(String name);
}
