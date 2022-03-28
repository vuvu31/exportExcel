package project.apicapstone.dto.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.entity.Department;
import project.apicapstone.entity.Employee;

import java.util.List;
@Data

public class PagingFormatDepartmentDto {
    private int pageNumber;

    private int pageSize;

    private Long totalRecordCount;

    private List<Department> records;
}
