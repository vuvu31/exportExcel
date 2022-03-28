package project.apicapstone.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.apicapstone.dto.allowance.PagingFormatAllowanceDto;
import project.apicapstone.dto.task.CreateTaskDto;
import project.apicapstone.dto.task.PagingFormatTaskDto;
import project.apicapstone.dto.task.UpdateTaskDto;
import project.apicapstone.entity.Task;
import project.apicapstone.repository.TaskRepository;
import project.apicapstone.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Page<Task> findAllTask(Pageable pageable) {
        return taskRepository.findAllTask(pageable);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task findTaskById(String id) {
        return taskRepository.getById(id);
    }

    @Override
    public List<Task> findTaskByNameOrId(String paramSearch) {
        return taskRepository.findTasksByNameOrId(paramSearch);
    }

    @Override
    public Object pagingFormat(Page<Task> taskPage) {
        PagingFormatTaskDto dto = new PagingFormatTaskDto();
        dto.setPageSize(taskPage.getSize());
        dto.setTotalRecordCount(taskPage.getTotalElements());
        dto.setPageNumber(taskPage.getNumber());
        dto.setRecords(taskPage.toList());
        return dto;
    }

    @Override
    public Task createTask(CreateTaskDto dto) {
        Task newTask = new Task();
        newTask.setTaskId(dto.getTaskId());
        newTask.setTaskName(dto.getTaskName());
        newTask.setOwner(dto.getOwner());
        newTask.setStatus(dto.getStatus());
        newTask.setStartDate(dto.getStartDate());
        newTask.setWorkPlan(dto.getWorkPlan());
        newTask.setDuration(dto.getDuration());
        newTask.setPriority(dto.getPriority());
        return taskRepository.save(newTask);
    }

    @Override
    public void updateTask(UpdateTaskDto dto, String taskId) {
        Task task = taskRepository.getById(taskId);
        task.setTaskName(dto.getTaskName());
        task.setOwner(dto.getOwner());
        task.setStatus(dto.getStatus());
        task.setStartDate(dto.getStartDate());
        task.setWorkPlan(dto.getWorkPlan());
        task.setDuration(dto.getDuration());
        task.setPriority(dto.getPriority());
        taskRepository.save(task);
    }

    @Override
    public boolean isExisted(String s) {
        return taskRepository.existsById(s);
    }
}
