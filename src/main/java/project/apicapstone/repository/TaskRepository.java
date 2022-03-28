package project.apicapstone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.apicapstone.entity.Employee;
import project.apicapstone.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,String> {
    @Query("SELECT e FROM Task e WHERE e.taskName LIKE %?1% OR e.taskId LIKE %?1%")
    List<Task> findTasksByNameOrId(String paramSearch);

    @Transactional(readOnly = true)
    @Query("SELECT t FROM Task t")
    Page<Task> findAllTask(Pageable pageable);
}
