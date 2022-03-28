package project.apicapstone.dto.dependant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.common.util.DateUtils;
import project.apicapstone.validation.annonation.CheckPhoneNumber;
import project.apicapstone.validation.annonation.FindEmployeeId;
import project.apicapstone.validation.annonation.UniqueDependantId;

import java.time.LocalDate;


@Data
public class CreateDependantDto {
    @UniqueDependantId
    private String dependantId;

    private String dependantName;

    private String gender;

    private String address;

    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate dateBirth;

    @CheckPhoneNumber
    private String phone;

    private String nationality;
    @FindEmployeeId
    private String employeeId;
}
