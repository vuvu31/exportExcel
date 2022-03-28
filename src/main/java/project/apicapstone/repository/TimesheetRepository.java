package project.apicapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.apicapstone.entity.Timesheet;
@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet,String> {
}
