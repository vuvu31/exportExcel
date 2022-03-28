package project.apicapstone.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.apicapstone.common.util.ResponseHandler;
import project.apicapstone.dto.allowance.CreateAllowanceDto;
import project.apicapstone.dto.allowance.UpdateAllowanceDto;
import project.apicapstone.dto.task.CreateTaskDto;
import project.apicapstone.dto.task.UpdateTaskDto;
import project.apicapstone.entity.Allowance;
import project.apicapstone.entity.Task;
import project.apicapstone.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/task")
public class TaskController {
    private TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping
    public Object findAllTask(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page, @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Task> taskPage = taskService.findAllTask(pageable);
        return ResponseHandler.getResponse(taskService.pagingFormat(taskPage), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public Object findAll() {
        List<Task> tasks = taskService.findAll();
        return ResponseHandler.getResponse(tasks, HttpStatus.OK);
    }

    @PostMapping("/create-task")
    public Object createTask(@Valid @RequestBody CreateTaskDto dto,
                                  BindingResult errors) {
        if (errors.hasErrors())
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

        Task createTask = taskService.createTask(dto);

        return ResponseHandler.getResponse(createTask, HttpStatus.CREATED);
    }

    @DeleteMapping()
    public Object deleteTask(@RequestParam(name = "id") String id) {
        taskService.deleteById(id);
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @PutMapping()
    public Object updateTask(@Valid @RequestBody UpdateTaskDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        taskService.updateTask(dto, dto.getTaskId());
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public Object findTaskById(@PathVariable("id") String id) {
        Task task = taskService.findTaskById(id);
        return ResponseHandler.getResponse(task, HttpStatus.OK);
    }

    @GetMapping("/search/{paramSearch}")
    public Object findTaskByNameOrId(@PathVariable String paramSearch) {
        List<Task> taskList = taskService.findTaskByNameOrId(paramSearch);
        if (taskList.isEmpty()) {
            return ResponseHandler.getErrors("Not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.getResponse(taskList, HttpStatus.OK);
    }
}
