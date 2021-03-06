package subd.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.*;
import subd.repository.TypeOfLessonRepository;

import java.util.List;

public class TypeOfLessonService {
    private TypeOfLessonRepository typeOfLessonRepository;

    public void readTypeOfLessons() {
        for (TypeOfLesson typeOfLesson: typeOfLessonRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(typeOfLesson);
        }
    }

    public void delTypeOfLesson() {
        typeOfLessonRepository.deleteById(1);
    }

    public void createTypeOfLesson(Integer id, String name){
        TypeOfLesson typeOfLesson = new TypeOfLesson();
        typeOfLesson.Constructor(id, name);
        typeOfLessonRepository.save(typeOfLesson);
    }

    public void updateTypeOfLesson(Integer id, String name) {
        TypeOfLesson typeOfLesson = new TypeOfLesson();
        typeOfLesson.Constructor(id, name);
        typeOfLessonRepository.save(typeOfLesson);
    }

    public List<TypeOfLesson> getAllByNameEquals(String type) {
        return typeOfLessonRepository.getAllByNameEquals(type);
    }

    public PageableItems<TypeOfLesson> findAll(int offset, int count) {
        final Page<TypeOfLesson> page = typeOfLessonRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

}
