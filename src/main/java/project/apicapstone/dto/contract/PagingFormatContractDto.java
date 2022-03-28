package project.apicapstone.dto.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.apicapstone.entity.Contract;
import project.apicapstone.entity.Department;

import java.util.List;
@Data
public class PagingFormatContractDto {
    private int pageNumber;

    private int pageSize;

    private Long totalRecordCount;

    private List<Contract> records;
}
