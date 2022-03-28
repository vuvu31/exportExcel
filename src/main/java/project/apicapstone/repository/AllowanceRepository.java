package project.apicapstone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.apicapstone.entity.Allowance;
import project.apicapstone.entity.Employee;

import java.util.List;

@Repository
public interface AllowanceRepository extends JpaRepository<Allowance,String> {
    @Transactional(readOnly = true)
    @Query("SELECT e FROM Allowance e")
    Page<Allowance> findAllAllowance(Pageable pageable);

    @Query("SELECT a FROM Allowance a WHERE a.allowanceName LIKE %?1% OR a.allowanceId LIKE %?1%")
    List<Allowance> findByAllowanceIdOrName(String paramSearch);


}
