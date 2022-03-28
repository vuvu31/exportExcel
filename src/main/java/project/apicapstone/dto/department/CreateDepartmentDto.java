package project.apicapstone.dto.department;

import lombok.Data;
import project.apicapstone.validation.annonation.CheckDepartmentId;
import project.apicapstone.validation.annonation.UniqueDepartmentId;
import project.apicapstone.validation.annonation.UniqueEmployeeId;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
@Data
public class CreateDepartmentDto {

    @CheckDepartmentId
    @UniqueDepartmentId
    private String departmentId;

    //@NotBlank(message = "{department.name.not-blank}")
    private String departmentName;


}
