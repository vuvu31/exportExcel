package project.apicapstone.dto.position;

import lombok.Data;
import project.apicapstone.validation.annonation.UniquePositionId;
@Data
public class UpdatePositionDto {
    //@UniquePositionId
    private String positionId;
    //@NotBlank(message = "{position.name.not-blank}")
    private String positionName;
}
