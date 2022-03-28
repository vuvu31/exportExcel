package project.apicapstone.dto.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.common.util.DateUtils;
import project.apicapstone.entity.util.WorkingStatus;
import project.apicapstone.validation.annonation.CheckEmployeeId;
import project.apicapstone.validation.annonation.CheckPhoneNumber;
import project.apicapstone.validation.annonation.FindTitleId;
import project.apicapstone.validation.annonation.UniqueEmployeeId;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class UpdateEmployeeDto {
//    @CheckEmployeeId
//    @UniqueEmployeeId
    private String employeeId;

    //@Size(min = 3, max = 25, message = "{employee.name.size}")
    private String employeeName;

    //@CheckDate
    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate dateBirth;

    private String placeBirth;

    @CheckPhoneNumber
    private String phone;

    private String gender;

    private String address;

    @Email
    private String email;

    private String nationality;

    private String religion;

    private String ethnic;

    private String academicLevel;

    private String bankAccountNo;

    private String bank;

    private String taxIdentificationNo;

    private String maritalStatus;

    private String workingStatus;

    private String avatar;

    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate updateDate;

    private String backIdentityCard;

    private String frontIdentityCard;
    @FindTitleId
    private String titleId;
}
