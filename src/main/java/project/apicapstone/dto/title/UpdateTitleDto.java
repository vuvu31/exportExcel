package project.apicapstone.dto.title;

import lombok.Data;
import project.apicapstone.validation.annonation.FindDepartmentId;
import project.apicapstone.validation.annonation.FindPositionId;

@Data
public class UpdateTitleDto {

    private String titleId;
    //@NotBlank(message = "{title.jobTitle.not-blank}")
    private String jobTitle;
    @FindPositionId
    private String positionId;
    @FindDepartmentId
    private String departmentId;
}
