package subd.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.OffsetablePageRequest;
import subd.model.PageableItems;
import subd.model.Participant;
import subd.model.Program;
import subd.repository.ProgramRepository;

import java.util.List;

public class ProgramService {
    private ProgramRepository programRepository;
    public void readPrograms() {
        for (Program program: programRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(program);
        }
    }

    public void delProgram() {
        programRepository.deleteById(1);
    }

    public void createProgram(Integer id, String name, String time){
        Program program = new Program();
        program.Constructor(id, name, time);
        programRepository.save(program);
    }

    public void updateProgram(Integer id, String name, String time) {
        Program program = new Program();
        program.Constructor(id, name, time);
        programRepository.save(program);
    }

    public List<Program> getAllByNameEquals(String name) {
        return programRepository.getAllByNameEquals(name);
    }

    public PageableItems<Program> findAll(int offset, int count) {
        final Page<Program> page = programRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

}
