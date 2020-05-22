package subd.repository;

import org.springframework.data.jpa.repository.Query;
import subd.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    @Query("SELECT e FROM Participant e")
    public List<Participant> getAllEmails();
}

