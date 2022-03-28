package project.apicapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.apicapstone.entity.Criteria;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria,String> {
}
