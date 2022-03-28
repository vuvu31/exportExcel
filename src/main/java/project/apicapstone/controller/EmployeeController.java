package project.apicapstone.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.apicapstone.common.util.ExporterExcelEmployee;
import project.apicapstone.common.util.ResponseHandler;
import project.apicapstone.dto.employee.CreateEmployeeDto;
import project.apicapstone.dto.employee.UpdateEmployeeDto;
import project.apicapstone.entity.Employee;
import project.apicapstone.service.EmployeeService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Object findAllEmployee(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page, @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeePage = employeeService.findAll(pageable);
        return ResponseHandler.getResponse(employeeService.pagingFormat(employeePage), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public Object findAll() {
        List<Employee> employees = employeeService.findAllEmployee();
        return ResponseHandler.getResponse(employees, HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public Object findEmployeeById(@PathVariable("id") String id) {
        Employee employee = employeeService.findEmployeeById(id);
        return ResponseHandler.getResponse(employee, HttpStatus.OK);
    }

    //    @GetMapping("")
//    public Object findEmployee(@RequestParam String employeeName) {
//        List<Employee> employeeList = employeeService.findEmployeeByName(employeeName);
//        //return ResponseEntity.ok(employeeList);
//        return ResponseHandler.getResponse(employeeList,HttpStatus.OK);
//    }
    @GetMapping("/search/{paramSearch}")
    public Object findEmployeeByNameOrId(@PathVariable String paramSearch) {
        List<Employee> employeeList = employeeService.findEmployeeByNameOrId(paramSearch);
        if (employeeList.isEmpty()) {
            return ResponseHandler.getErrors("Not found ", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.getResponse(employeeList, HttpStatus.OK);
    }

    @PostMapping
    public Object createEmployee(@Valid @RequestBody CreateEmployeeDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        Employee createEmployee = employeeService.addNewEmployee(dto);
        return ResponseHandler.getResponse(createEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping()
    public Object deleteEmployee(@RequestParam(name = "id") String id) {
        employeeService.deleteById(id);
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @PutMapping()
    public Object updateEmployee(@Valid @RequestBody UpdateEmployeeDto dto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
        }
        employeeService.updateEmployee(dto, dto.getEmployeeId());
        return ResponseHandler.getResponse(HttpStatus.OK);
    }

    @GetMapping("/count-by-week")
    public Object countByWeek() {
        int count = employeeService.countByWeek();
        return ResponseHandler.getResponse(count, HttpStatus.OK);
    }

//    @GetMapping("/count-by-month")
//    public Object countByMonth() {
//        int count = employeeService.countByMonth();
//        return ResponseHandler.getResponse(count, HttpStatus.OK);
//    }

    @GetMapping("/count-by-year")
    public Object countByYear() {
        int count = employeeService.countByYear();
        return ResponseHandler.getResponse(count, HttpStatus.OK);
    }

    @GetMapping("/count-all")
    public Object countAll() {
        int count = employeeService.countAll();
        return ResponseHandler.getResponse(count, HttpStatus.OK);
    }

    @GetMapping("/count-by")
    public Object countByStatus(@RequestParam(name = "status") String status) {
        int count = employeeService.countByStatus(status);
        return ResponseHandler.getResponse(count, HttpStatus.OK);
    }

    @GetMapping("/count-all-every-month")
    public Object countByEveryMonth() {
        int[] result = employeeService.countByMonth();
        return ResponseHandler.getResponse(result, HttpStatus.OK);
    }

    @GetMapping("/count-every-month")
    public Object countByEveryMonthWithStatus(@RequestParam(name = "status") String status) {
        int[] result = employeeService.countByMonthWithStatus(status);
        return ResponseHandler.getResponse(result, HttpStatus.OK);
    }

    @GetMapping("/check-birth")
    public Object checkBirth() {
        List<Employee> employee = employeeService.getBirth();
        return ResponseHandler.getResponse(employee, HttpStatus.OK);
    }

    /*@GetMapping("/exportList/excel")
    public Object exportListToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerValue = "attachement; filename=HSNV.xlsx";
        String headerKey = "Content-Disposition";
        response.setHeader(headerKey, headerValue);

        List<Employee> listEmployees = employeeService.findAllEmployee();
        if (listEmployees.isEmpty()) {
            return ResponseHandler.getErrors("Not found ", HttpStatus.NOT_FOUND);
        }
        ExporterExcelEmployee excelExporter = new ExporterExcelEmployee(listEmployees);
        excelExporter.exportList(response);
        return ResponseHandler.getResponse(excelExporter, HttpStatus.OK);
    }


    @GetMapping("{id}/exportEmployee/excel")
    public Object exportEmployee(@PathVariable String id, HttpServletResponse response) throws IOException {
        Employee employee = employeeService.findEmployeeById(id);

        response.setContentType("application/octet-stream");
        String headerValue = "attachement; filename=HSNV_" + employee.getEmployeeId() + ".xlsx";
        String headerKey = "Content-Disposition";

        response.setHeader(headerKey, headerValue);
        ExporterExcelEmployee excelExporter = new ExporterExcelEmployee(employee);
        excelExporter.export(response);
        return ResponseHandler.getResponse(excelExporter, HttpStatus.OK);
    }*/
}
