package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Program;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
    public List<Program> getAllByNameEquals(String name);
}
