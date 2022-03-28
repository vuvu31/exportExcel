package project.apicapstone.dto.dependant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.apicapstone.entity.Department;
import project.apicapstone.entity.Dependant;

import java.util.List;
@Data
public class PagingFormatDependantDto {
    private int pageNumber;

    private int pageSize;

    private Long totalRecordCount;

    private List<Dependant> records;
}
