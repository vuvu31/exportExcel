package project.apicapstone.dto.applicant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.common.util.DateUtils;
import project.apicapstone.validation.annonation.CheckPhoneNumber;
import project.apicapstone.validation.annonation.FindJobPostingId;
import project.apicapstone.validation.annonation.UniqueApplicantId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class CreateApplicantDto {
    @UniqueApplicantId
    private String applicantId;

    //@NotBlank(message = "{applicant.name.not-blank}")
    private String applicantName;

    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate dateBirth;

    //@NotBlank(message = "{applicant.address.not-blank}")
    private String address;

    @CheckPhoneNumber
    private String phone;

    //@NotBlank(message = "{applicant.gender.not-blank}")
    private String gender;

    @Email
    private String email;

    private String certification;

   // @NotBlank(message = "{applicant.status.not-blank}")
    private String status;

    private String resumeFile;

    @FindJobPostingId
    private String jobPostingId;
}
