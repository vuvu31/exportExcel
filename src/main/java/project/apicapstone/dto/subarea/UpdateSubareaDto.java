package project.apicapstone.dto.subarea;

import lombok.Data;
import project.apicapstone.validation.annonation.FindAreaId;

@Data
public class UpdateSubareaDto {

    private String subareaId;

    private String name;

    private String description;

    @FindAreaId
    private String areaId;
}
