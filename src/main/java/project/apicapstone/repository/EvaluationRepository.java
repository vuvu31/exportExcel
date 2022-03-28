package project.apicapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.apicapstone.entity.Evaluation;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,String> {
}
