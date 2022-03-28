package project.apicapstone.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.apicapstone.common.util.ResponseHandler;
import project.apicapstone.dto.department.CreateDepartmentDto;
import project.apicapstone.dto.department.UpdateDepartmentDto;
import project.apicapstone.dto.employee.CreateEmployeeDto;
import project.apicapstone.dto.employee.UpdateEmployeeDto;
import project.apicapstone.entity.Department;
import project.apicapstone.entity.Employee;
import project.apicapstone.service.DepartmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/get-all")
    public Object findAll() {
        List<Department> departments = departmentService.findAll();
        return ResponseHandler.getResponse(departments, HttpStatus.OK);
    }

    @GetMapping
    public Object findAllDepartment(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page, @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Department> departmentPage = departmentService.findAllDepartment(pageable);
        return ResponseHandler.getResponse(departmentService.pagingFormat(departmentPage), HttpStatus.OK);
    }

    @PostMapping
    public Object createDepartment(@Valid @RequestBody CreateDepartmentDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        Department createDepartment = departmentService.addNewDepartment(dto);
        return ResponseHandler.getResponse(createDepartment, HttpStatus.CREATED);
    }

    @DeleteMapping()
    public Object deleteDepartment(@RequestParam(name = "id") String id) {
        departmentService.deleteById(id);
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @PutMapping()
    public Object updateDepartment(@Valid @RequestBody UpdateDepartmentDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        departmentService.updateDepartment(dto, dto.getDepartmentId());
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public Object findDepartmentById(@PathVariable("id") String id) {
        Department department = departmentService.findEmployeeById(id);
        return ResponseHandler.getResponse(department, HttpStatus.OK);
    }

    @GetMapping("/search/{paramSearch}")
    public Object findDepartmentByNameOrId(@PathVariable String paramSearch) {
        List<Department> departmentList = departmentService.findDepartmentByNameOrId(paramSearch);
        if (departmentList.isEmpty()) {
            return ResponseHandler.getErrors("Not found ", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.getResponse(departmentList, HttpStatus.OK);
    }

}
