package project.apicapstone.dto.position;

import lombok.Data;
import project.apicapstone.validation.annonation.UniquePositionId;

import javax.validation.constraints.NotBlank;

@Data
public class CreatePositionDto {
    @UniquePositionId
    private String positionId;
    //@NotBlank(message = "{position.name.not-blank}")
    private String positionName;
}
