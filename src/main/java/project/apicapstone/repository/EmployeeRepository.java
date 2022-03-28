package project.apicapstone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.apicapstone.entity.Employee;
import project.apicapstone.entity.Title;
import project.apicapstone.entity.util.WorkingStatus;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    //List<Employee> findEmployeesByEmployeeName(String employeeName);
    List<Employee> findEmployeesByEmployeeNameContains(String employeeName);

    //
    @Query("SELECT e FROM Employee e WHERE e.employeeName LIKE %?1% OR e.employeeId LIKE %?1%")
    List<Employee> findEmployeesByNameOrId(String paramSearch);

    @Transactional(readOnly = true)
    @Query("SELECT e FROM Employee e")
    Page<Employee> findAllEmp(Pageable pageable);

    int countByCreateDateBetweenAndWorkingStatusNotContains(LocalDate start, LocalDate end, String workingStatus);

    int countByCreateDateBetween(LocalDate start, LocalDate end);

    int countByUpdateDateBetweenAndWorkingStatus(LocalDate start, LocalDate end, String workingStatus);

    @Query("SELECT COUNT(e.employeeId) FROM Employee e")
    int countAll();

    int countEmployeeByWorkingStatus(String workingStatus);

//    @Query("SELECT e.dateBirth FROM Employee e")
//    List<LocalDate> getAllBirth();

    List<Employee> getAllByDayOfBirthAndMonthOfBirth(int day, int month);



}
