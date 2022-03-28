package project.apicapstone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.apicapstone.entity.Account;
import project.apicapstone.entity.Title;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
//    @Query("SELECT a FROM Account a LEFT JOIN FETCH a.roles WHERE a.username = ?1")
//    Optional<Account> findByUsernameWithRoles(String username);

     Account findByUsername(String username);

    int countByUsername(String username);

    Account findByUsernameAndStatus(String username, String status);

    //Title findByUsername(String username);

    @Transactional(readOnly = true)
    @Query("SELECT e FROM Account e")
    Page<Account> findAllAccount(Pageable pageable);

    @Query("SELECT t.jobTitle FROM Account a JOIN a.employee e JOIN e.title t WHERE a.username = ?1")
    String findTitleByUsername(String username);
}
