package subd.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.*;
import subd.repository.EventProgramRepository;

import java.util.List;

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

    public void updateEventPrograms(Integer id, String name) {
        EventProgram eventProgram = new EventProgram();
        eventProgram.Constructor(id, name);
        eventProgramRepository.save(eventProgram);
    }

    public List<EventProgram> getAllByNameEquals(String name) {
        return eventProgramRepository.getAllByNameEquals(name);
    }

    public PageableItems<EventProgram> findAll(int offset, int count) {
        final Page<EventProgram> page = eventProgramRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }


}
