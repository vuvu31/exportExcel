package project.apicapstone.dto.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.apicapstone.validation.annonation.UniqueRoleId;
import project.apicapstone.validation.annonation.UniqueRoleName;

import javax.persistence.Column;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CreateRoleDto {
    @UniqueRoleId
    private String roleId;

    @UniqueRoleName
    private String roleName;

    private String roleDescription;
}
