package project.apicapstone.dto.workplace;


import lombok.Data;
import project.apicapstone.validation.annonation.FindSubareaId;
import project.apicapstone.validation.annonation.UniqueWorkplaceId;

@Data
public class CreateWorkplaceDto {
    @UniqueWorkplaceId
    private String workplaceId;

    private String name;

    private String address;

    private String type;

    @FindSubareaId
    private String subareaId;
}
