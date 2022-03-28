package project.apicapstone.dto.title;

import lombok.Data;
import project.apicapstone.validation.annonation.FindDepartmentId;
import project.apicapstone.validation.annonation.FindPositionId;
import project.apicapstone.validation.annonation.FindTitleId;
import project.apicapstone.validation.annonation.UniqueTitleId;

import javax.validation.constraints.NotBlank;

@Data
public class CreateTitleDto {
    @UniqueTitleId
    private String titleId;
    //@NotBlank(message = "{title.jobTitle.not-blank}")
    private String jobTitle;
    @FindPositionId
    private String positionId;
    @FindDepartmentId
    private String departmentId;

}
