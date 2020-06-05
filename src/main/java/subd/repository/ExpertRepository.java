package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.EventProgram;
import subd.model.Expert;

import java.util.List;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Integer> {
    List<Expert> getAllByNameEquals(String lastName);
}

