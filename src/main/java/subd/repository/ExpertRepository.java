package subd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import subd.model.Expert;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Integer> {
}

