package subd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import subd.repository.*;
import subd.service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class App {
    private EventProgramRepository eventProgramRepository;
    private ExpertRepository expertRepository;
    private ParticipantRepository participantRepository;
    private ProgramRepository programRepository;
    private SessionRepository sessionRepository;
    private TypeOfLessonRepository typeOfLessonRepository;

    private EventProgramService eventProgramService;
    private ExpertService expertService;
    private ParticipantService participantService;
    private ProgramService programService;
    private SessionService sessionService;
    private TypeOfLessonService typeOfLessonService;

    @Autowired
    public App(EventProgramRepository eventProgramRepository,
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

        SpringApplication.run(App.class,args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStart() throws ParseException {

        participantService.createParticipant(1, "Razinova", "tt@gmail.com");
        participantService.createParticipant(1, "Matchina", "trrt@gmail.com");
        participantService.readParticipants();

        System.out.println((participantRepository.findEmails()));

        programService.createProgram(1, "bigboom", "2020-05-03 10:00");
        System.out.println(programRepository.findPrograms());

        programService.createProgram(1, "bigboom", "2020-05-03 10:00");
        System.out.println(programRepository.getAllByNameEquals("bigboom"));

        sessionService.createSession(1, "Stachka", "Samara", "31-08-2010 10:00:00",
                "10-09-2020 18:00:00");
        sessionService.readSessions();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String Date = "01-09-2010 10:00:00";
        Date dateParse = sdf.parse(Date);
        System.out.println((sessionRepository.getAllByDateBetween(dateParse)));
        }
}
