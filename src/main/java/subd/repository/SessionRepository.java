package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import subd.model.EventProgram;
import subd.model.Session;

import java.util.Date;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    @Query("SELECT e.name, e.place, e.dataFrom FROM Session e WHERE e.dateFrom <= current_date " +
            "and e.dateTo >= :date ORDER BY e.place, e.dataFrom" )
    public List<Session> getAllByDateBetween(Date date);

    List<Session> getAllByNameEquals(String name);

}
