package project.apicapstone.dto.area;

import lombok.Data;
import project.apicapstone.validation.annonation.UniqueAreaId;

@Data
public class UpdateAreaDto {

    private String areaId;

    private String name;

    private String description;
}
