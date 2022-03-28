package project.apicapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import project.apicapstone.entity.Workplace;

@Repository
public interface WorkplaceRepository extends JpaRepository<Workplace,String> {

    Workplace findByWorkplaceId(String id);
}
