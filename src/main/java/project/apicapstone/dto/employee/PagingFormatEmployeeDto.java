package project.apicapstone.dto.employee;

import lombok.*;
import project.apicapstone.entity.Employee;

import java.util.List;

@Data
public class PagingFormatEmployeeDto {
    private int pageNumber;

    private int pageSize;

    private Long totalRecordCount;

    private List<Employee> records;

}
