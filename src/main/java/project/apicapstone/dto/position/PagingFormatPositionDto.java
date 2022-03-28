package project.apicapstone.dto.position;

import lombok.Data;
import project.apicapstone.entity.Position;


import java.util.List;
@Data
public class PagingFormatPositionDto {
    private int pageNumber;

    private int pageSize;

    private Long totalRecordCount;

    private List<Position> records;
}
