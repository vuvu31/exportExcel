package project.apicapstone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.apicapstone.entity.Allowance;
import project.apicapstone.entity.Title;

import java.util.List;

@Repository
public interface TitleRepository extends JpaRepository<Title, String> {
    //@Transactional(readOnly = true)
    @Query("SELECT e FROM Title e")
    Page<Title> findAllAllTitle(Pageable pageable);

    @Query("SELECT t FROM Title t WHERE t.jobTitle LIKE %?1% OR t.titleId LIKE %?1%")
    List<Title> findTitlesByNameOrId(String paramSearch);

    @Query("SELECT t FROM Title t JOIN t.department d JOIN t.position p WHERE p.positionId = ?1 AND d.departmentId =?2")
    Title findTitleByPositionIdAndDepartmentId(String positionId, String departmentId);
}
