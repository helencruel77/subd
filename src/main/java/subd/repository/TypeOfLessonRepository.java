package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Session;
import subd.model.TypeOfLesson;

import java.util.List;

@Repository
public interface TypeOfLessonRepository extends JpaRepository<TypeOfLesson, Integer> {
    List<TypeOfLesson> getAllByNameEquals(String type);
}