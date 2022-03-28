package project.apicapstone.dto.role;

import lombok.Data;
import project.apicapstone.validation.annonation.UniqueRoleId;
import project.apicapstone.validation.annonation.UniqueRoleName;
@Data
public class UpdateRoleDto {

    private String roleId;

    @UniqueRoleName
    private String roleName;

    private String roleDescription;
}
