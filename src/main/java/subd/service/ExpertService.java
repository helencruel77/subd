package subd.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.EventProgram;
import subd.model.Expert;
import subd.model.OffsetablePageRequest;
import subd.model.PageableItems;
import subd.repository.ExpertRepository;

import java.util.List;

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

    public List<Expert> getAllByNameEquals(String lastName) {
        return expertRepository.getAllByNameEquals(lastName);
    }

    public PageableItems<Expert> findAll(int offset, int count) {
        final Page<Expert> page = expertRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

}
