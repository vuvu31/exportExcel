package project.apicapstone.dto.allowance;

import lombok.Data;
import project.apicapstone.validation.annonation.FindContractId;
import project.apicapstone.validation.annonation.UniqueAllowanceId;

import javax.validation.constraints.NotBlank;


@Data
public class CreateAllowanceDto {
    @UniqueAllowanceId
    private String allowanceId;
    //@NotBlank(message = "{allowance.name.not-blank}")
    private String allowanceName;
    //@NotBlank(message = "{allowance.type.not-blank}")
    private String type;
    private float amount;
    @FindContractId
    private String contractId;
}
