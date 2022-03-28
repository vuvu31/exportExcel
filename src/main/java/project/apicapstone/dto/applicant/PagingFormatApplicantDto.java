package project.apicapstone.dto.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.apicapstone.entity.Allowance;
import project.apicapstone.entity.Applicant;

import java.util.List;
@Data

public class PagingFormatApplicantDto {
    private int pageNumber;

    private int pageSize;

    private Long totalRecordCount;

    private List<Applicant> records;
}
