package project.apicapstone.dto.jobPosting;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.common.util.DateUtils;
import project.apicapstone.validation.annonation.FindTitleId;

@Data
public class UpdateJobPostingDto {

    private String jobPostingId;

    private String vacancies;

    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private String datePost;

    private String employmentInfor;

    private String jobDescription;

    private String jobRequirements;

    private String status;

    @FindTitleId
    private String titleId;
}
