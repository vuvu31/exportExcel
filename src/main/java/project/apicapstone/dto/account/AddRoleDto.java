package project.apicapstone.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.apicapstone.validation.annonation.FindAccountId;
import project.apicapstone.validation.annonation.FindRoleId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddRoleDto {
    // @NotBlank(message = "{account.id.not-blank}")
    @FindAccountId
    private String accountId;
    //    @NotBlank(message = "{role.id.not-blank}")
    @FindRoleId
    private String roleId;
}
