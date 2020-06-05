package subd.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.EventProgram;
import subd.model.Expert;
import subd.repository.ExpertRepository;

public class ExpertService {
    private ExpertRepository expertRepository;

    public void readExperts() {
        for (Expert expert: expertRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(expert);
        }
    }

    public void delExpert() {
        expertRepository.deleteById(1);
    }

    public void createExpert(Integer id, String lastName){
        Expert expert = new Expert();
        expert.Constructor(id, lastName);
        expertRepository.save(expert);
    }
    public void updateExpert(Integer id, String lastName) {
        Expert expert = new Expert();
        expert.Constructor(id, lastName);
        expertRepository.save(expert);
    }
}
