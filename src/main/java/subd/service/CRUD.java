package subd.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.Expert;
import subd.model.Participant;
import subd.model.Program;
import subd.model.Session;
import subd.repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CRUD {
    private EventProgramRepository eventProgramRepository;
    private ExpertRepository expertRepository;
    private ParticipantRepository participantRepository;
    private ProgramRepository programRepository;
    private SessionRepository sessionRepository;
    private TypeOfLessonRepository typeOfLessonRepository;

    public void readExperts() {
        for (Expert expert: expertRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(expert);
        }
    }
    public void createSession(Integer id, String name, String place, String DataFrom, String DataTo)
            throws ParseException {
        Session session = new Session();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date dateFrom = sdf.parse(DataFrom);
        Date dateTo = sdf.parse(DataTo);
        session.Constructor(id,name, place, dateFrom, dateTo);
        sessionRepository.save(session);
    }

    public void readSessions() {
        for (Session session: sessionRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(session);
        }
    }

    public void delExpert() {
        expertRepository.deleteById(1);
    }

    public void updateClient(Integer id, String lastName) {
        Expert expert = new Expert();
        expert.Constructor(id, lastName);
        expertRepository.save(expert);
    }
    public void createParticipant(Integer id, String lastName, String email){
        Participant participant = new Participant();
        participant.Constructor(id, lastName,email);
        participantRepository.save(participant);
    }

    public void readParticipants() {
        for (Participant participant: participantRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(participant);
        }
    }

    public void createProgram(Integer id, String name, String time){
        Program program = new Program();
        program.Constructor(id, name, time);
        programRepository.save(program);
    }

    public void readPrograms() {
        for (Program program: programRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(program);
        }
    }

    public void createExpert(Integer id, String lastName){
        Expert expert = new Expert();
        expert.Constructor(id, lastName);
        expertRepository.save(expert);
    }
}
