package subd.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.EventProgram;
import subd.model.Expert;
import subd.model.Program;
import subd.repository.EventProgramRepository;

public class EventProgramService {
    private EventProgramRepository eventProgramRepository;

    public void createEventProgram(Integer id, String name){
        EventProgram eventProgram = new EventProgram();
        eventProgram.Constructor(id, name);
        eventProgramRepository.save(eventProgram);
    }

    public void readEventPrograms() {
        for (EventProgram eventProgram: eventProgramRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(eventProgram);
        }
    }

    public void delEventPrograms() {
        eventProgramRepository.deleteById(1);
    }

    public void updateClient(Integer id, String name) {
        EventProgram eventProgram = new EventProgram();
        eventProgram.Constructor(id, name);
        eventProgramRepository.save(eventProgram);
    }
}
