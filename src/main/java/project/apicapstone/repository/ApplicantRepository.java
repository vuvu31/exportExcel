package project.apicapstone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.apicapstone.entity.Account;
import project.apicapstone.entity.Applicant;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,String> {
    @Transactional(readOnly = true)
    @Query("SELECT e FROM Applicant e")
    Page<Applicant> findAllApplicant(Pageable pageable);

    @Query("SELECT e FROM Applicant e WHERE e.applicantName LIKE %?1% OR e.applicantId LIKE %?1%")
    List<Applicant> findApplicantsByNameOrId(String paramSearch);
}
