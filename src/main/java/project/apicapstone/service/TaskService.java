package project.apicapstone.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import project.apicapstone.dto.task.CreateTaskDto;
import project.apicapstone.dto.task.UpdateTaskDto;
import project.apicapstone.entity.Task;

import java.util.List;

public interface TaskService {
    Page<Task> findAllTask(Pageable pageable);

    List<Task> findAll();

    void deleteById(String id);

    Task findTaskById(String id);

    List<Task> findTaskByNameOrId(String paramSearch);

    Object pagingFormat(Page<Task> taskPage);

    Task createTask(CreateTaskDto dto);

    void updateTask(UpdateTaskDto dto, String taskId);

    boolean isExisted(String s);
}
