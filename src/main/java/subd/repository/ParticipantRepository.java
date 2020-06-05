package subd.repository;

import org.springframework.data.jpa.repository.Query;
import subd.model.Expert;
import subd.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    @Query("SELECT e.email FROM Participant e GROUP BY e.email")
    ArrayList<Participant> findEmails();

    List<Participant> getAllByNameEquals(String lastName);
}

