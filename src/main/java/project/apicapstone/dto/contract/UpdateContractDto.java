package project.apicapstone.dto.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.common.util.DateUtils;
import project.apicapstone.validation.annonation.CheckEmployeeId;
import project.apicapstone.validation.annonation.CheckEmployeeIdExistInContract;
import project.apicapstone.validation.annonation.CheckEmployeeIdInContract;
import project.apicapstone.validation.annonation.FindEmployeeId;


import java.time.LocalDate;

@Data
@CheckEmployeeIdInContract
public class UpdateContractDto {
    private String contractId;

    private String contractName;

    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate startDate;

//    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
//    private LocalDate endDate;

    // @NotBlank(message = "{contract.status.not-blank}")
    private String status;

    private double salary;

    private String type;

    private Long duration;

    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate signDate;

    private String wage;

    private String note;

    private String attachedFile;

   // @FindEmployeeId
    private String employeeId;
}
