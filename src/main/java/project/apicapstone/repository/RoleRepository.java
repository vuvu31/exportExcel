package project.apicapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.apicapstone.entity.Employee;
import project.apicapstone.entity.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
    int countByRoleName(String roleName);

    @Query("SELECT r FROM Role r WHERE r.roleName LIKE %?1% OR r.roleDescription LIKE %?1%")
    List<Role> findRolesByNameOrId(String paramSearch);
}
