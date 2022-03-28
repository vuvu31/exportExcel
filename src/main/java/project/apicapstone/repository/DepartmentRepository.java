package project.apicapstone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.apicapstone.entity.Department;
import project.apicapstone.entity.Employee;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Transactional(readOnly = true)
    @Query("SELECT d FROM Department d")
    Page<Department> findALlDepartment(Pageable pageable);

    @Query("SELECT e FROM Department e WHERE e.departmentName LIKE %?1% OR e.departmentId LIKE %?1%")
    List<Department> findDepartmentsByNameOrId(String paramSearch);
}
