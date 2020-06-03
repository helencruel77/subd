package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import subd.model.Participant;
import subd.model.Program;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
    public List<Program> getAllByNameEquals(String name);

    @Query("SELECT e.id, e.name, e.dataFrom FROM Program e ORDER BY e.dataFrom ASC")
    ArrayList<Participant> findPrograms();
}
