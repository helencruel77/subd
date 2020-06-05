package subd.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.Expert;
import subd.model.Participant;
import subd.repository.ParticipantRepository;

import java.util.List;

public class ParticipantService {
    private ParticipantRepository participantRepository;
    public void readParticipants() {
        for (Participant participant: participantRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(participant);
        }
    }

    public void delParticipant() {
        participantRepository.deleteById(1);
    }

    public void createParticipant(Integer id, String lastName, String email){
        Participant participant = new Participant();
        participant.Constructor(id, lastName, email);
        participantRepository.save(participant);
    }
    public void updateParticipant(Integer id, String lastName, String email) {
        Participant participant = new Participant();
        participant.Constructor(id, lastName, email);
        participantRepository.save(participant);
    }

    public List<Participant> getAllByNameEquals(String lastName) {
        return participantRepository.getAllByNameEquals(lastName);
    }

}
