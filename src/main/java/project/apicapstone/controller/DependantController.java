package project.apicapstone.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.apicapstone.common.util.ResponseHandler;
import project.apicapstone.dto.department.CreateDepartmentDto;
import project.apicapstone.dto.dependant.CreateDependantDto;
import project.apicapstone.dto.dependant.UpdateDependantDto;
import project.apicapstone.dto.employee.UpdateEmployeeDto;
import project.apicapstone.entity.Department;
import project.apicapstone.entity.Dependant;
import project.apicapstone.entity.Employee;
import project.apicapstone.service.DependantService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/dependant")
public class DependantController {
    private DependantService dependantService;

    public DependantController(DependantService dependantService) {
        this.dependantService = dependantService;
    }

    @GetMapping("/get-all")
    public Object findAll() {
        List<Dependant> dependants = dependantService.findAll();
        return ResponseHandler.getResponse(dependants, HttpStatus.OK);
    }

    @GetMapping
    public Object findAllDependant(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page, @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Dependant> dependantPage = dependantService.findAllDependant(pageable);
        return ResponseHandler.getResponse(dependantService.pagingFormat(dependantPage), HttpStatus.OK);
    }

    @PostMapping
    public Object createDependant(@Valid @RequestBody CreateDependantDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        Dependant createDependant = dependantService.createDependant(dto);
        return ResponseHandler.getResponse(createDependant, HttpStatus.CREATED);
    }
    @GetMapping("/search/{paramSearch}")
    public Object findDependantByNameOrId(@PathVariable String paramSearch) {
        List<Dependant> dependantList = dependantService.findDependantByNameOrId(paramSearch);
        if (dependantList.isEmpty()) {
            return ResponseHandler.getErrors("Not found ",HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.getResponse(dependantList, HttpStatus.OK);
    }
    @DeleteMapping()
    public Object deleteDependant(@RequestParam(name = "id") String id) {
        dependantService.deleteById(id);
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @PutMapping()
    public Object updateDependant(@Valid @RequestBody UpdateDependantDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        dependantService.updateDependant(dto, dto.getDependantId());
        return ResponseHandler.getResponse(HttpStatus.OK);
    }
    @GetMapping("/get-by-id/{id}")
    public Object findDependantById(@PathVariable("id") String id) {
        Dependant dependant = dependantService.findDependantById(id);
        return ResponseHandler.getResponse(dependant, HttpStatus.OK);
    }
}
