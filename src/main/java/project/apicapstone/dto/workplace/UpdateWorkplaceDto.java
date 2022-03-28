package project.apicapstone.dto.workplace;

import lombok.Data;
import project.apicapstone.validation.annonation.FindSubareaId;

@Data
public class UpdateWorkplaceDto {

    private String workplaceId;

    private String name;

    private String address;

    private String type;

    @FindSubareaId
    private String subareaId;
}
