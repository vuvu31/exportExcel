package project.apicapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.apicapstone.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area,String> {
}
