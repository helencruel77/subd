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
    public void onStart() {

        }
    private void createExpert(Integer id, String fio){
        Expert expert = new Expert();
        expert.Constructor(id,fio);
        expertRepository.save(expert);
    }

    private  void readExperts() {
        expertRepository.findAll(PageRequest.of(0, 3, Sort.Direction.DESC, "fio"))
                .toList()
                .forEach(System.out::println);
    }
}
