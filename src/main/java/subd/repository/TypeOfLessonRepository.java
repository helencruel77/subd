package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Type_of_lesson;

@Repository
public interface TypeOfLessonRepository extends JpaRepository<Type_of_lesson, Integer> {
}