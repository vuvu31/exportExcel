package project.apicapstone.dto.subarea;

import lombok.Data;
import project.apicapstone.validation.annonation.FindAreaId;
import project.apicapstone.validation.annonation.UniqueSubareaId;

@Data
public class CreateSubareaDto {
    @UniqueSubareaId
    private String subareaId;

    private String name;

    private String description;

    @FindAreaId
    private String areaId;
}
