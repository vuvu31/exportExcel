package project.apicapstone.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.apicapstone.validation.annonation.ConfirmPassword;
import project.apicapstone.validation.annonation.FindEmployeeId;
import project.apicapstone.validation.annonation.UniqueAccountId;
import project.apicapstone.validation.annonation.UniqueUsername;

import javax.validation.constraints.NotBlank;

@Data
@ConfirmPassword
public class CreateAccountDto {
//    @UniqueAccountId
//    private String accountId;
    @UniqueUsername
    private String username;
//    @NotBlank(message = "{account.password.not-blank}")
    private String password;
    private String confirmPassword;
//    @NotBlank(message = "{account.status.not-blank}")
//    private String status;
    @FindEmployeeId
    private String employeeId;

}
