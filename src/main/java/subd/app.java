package subd;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import subd.model.*;
import subd.repository.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class app {
    private EventProgramRepository eventProgramRepository;
    private ExpertRepository expertRepository;
    private ParticipantRepository participantRepository;
    private ProgramRepository programRepository;
    private SessionRepository sessionRepository;
    private TypeOfLessonRepository typeOfLessonRepository;

    @Autowired
    public app(EventProgramRepository eventProgramRepository,
               ExpertRepository expertRepository,
               ParticipantRepository participantRepository,
               ProgramRepository programRepository,
               SessionRepository sessionRepository,
               TypeOfLessonRepository typeOfLessonRepository){
        this.eventProgramRepository = eventProgramRepository;
        this.expertRepository = expertRepository;
        this.participantRepository = participantRepository;
        this.programRepository = programRepository;
        this.sessionRepository = sessionRepository;
        this.typeOfLessonRepository = typeOfLessonRepository;
    }

    public static void main(String[] args){

        SpringApplication.run(app.class,args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStart() throws ParseException {
       // createExpert(1, "Razinova Elena Sergeevna");
       // readExperts();

      //  createProgram(1, "bigboom", "2020-05-03 10:00");
     //  System.out.println(programRepository.getAllByNameEquals("bigboom"));
      //  readPrograms();


    createSession(1, "Stachka", "Samara", "31-08-2010 10:00:00", "10-09-2020 18:00:00");
    readSessions();
        Date date = new Date(System.currentTimeMillis()-2592000000L);
   // System.out.println((sessionRepository.getAllByDateBetween(date)));
        }

    private void createExpert(Integer id, String fio){
        Expert expert = new Expert();
        expert.Constructor(id,fio);
        expertRepository.save(expert);
    }

    private void readExperts() {
        for (Expert expert: expertRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(expert);
        }
    }
    private void createSession(Integer id, String name, String place, String DataFrom, String DataTo)
            throws ParseException {
        Session session = new Session();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date dateFrom = sdf.parse(DataFrom);
        Date dateTo = sdf.parse(DataTo);
        session.Constructor(id,name, place, dateFrom, dateTo);
        sessionRepository.save(session);
    }

    private void readSessions() {
        for (Session session: sessionRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(session);
        }
    }

    private void delExpert() {
        expertRepository.deleteById(1);
    }

    private void updateClient(Integer id, String fio) {
        Expert expert = new Expert();
        expert.Constructor(id,fio);
        expertRepository.save(expert);
    }
    private void createParticipant(Integer id, String fio, String email){
        Participant participant = new Participant();
        participant.Constructor(id,fio,email);
        participantRepository.save(participant);
    }

    private void readParticipants() {
        for (Participant participant: participantRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(participant);
        }
    }

    private void createProgram(Integer id, String name, String time){
    Program program = new Program();
    program.Constructor(id, name, time);
    programRepository.save(program);
    }

    private void readPrograms() {
        for (Program program: programRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(program);
        }
    }
}
