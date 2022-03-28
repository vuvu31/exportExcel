package project.apicapstone.dto.allowance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.apicapstone.entity.Allowance;
import project.apicapstone.entity.Contract;

import java.util.List;
@Data
public class PagingFormatAllowanceDto {
    private int pageNumber;

    private int pageSize;

    private Long totalRecordCount;

    private List<Allowance> records;
}
