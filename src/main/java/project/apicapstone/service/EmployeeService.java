package project.apicapstone.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.apicapstone.dto.employee.CreateEmployeeDto;
import project.apicapstone.dto.employee.PagingFormatEmployeeDto;
import project.apicapstone.dto.employee.UpdateEmployeeDto;
import project.apicapstone.entity.Employee;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    PagingFormatEmployeeDto pagingFormat(Page<Employee> employeePage);

    List<Employee> findEmployeeByName(String employeeName);

    Employee addNewEmployee(CreateEmployeeDto dto);

    List<Employee> findEmployeeByNameOrId(String paramSearch);

    boolean isExisted(String s);


    List<Employee> findAllEmployee();

    void deleteById(String id);

    Employee findEmployeeById(String id);

    void updateEmployee(UpdateEmployeeDto dto, String id);

    int countByWeek();

    //int countByMonth();

    int countByYear();

    int countAll();

    int countByStatus(String status);

    int[] countByMonth();

    int[] countByMonthWithStatus(String status);

    List<Employee> getBirth();
}
