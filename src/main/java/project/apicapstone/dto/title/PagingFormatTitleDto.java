package project.apicapstone.dto.title;

import lombok.*;
import project.apicapstone.entity.Employee;
import project.apicapstone.entity.Title;

import java.util.List;
@Data
public class PagingFormatTitleDto {
    private int pageNumber;

    private int pageSize;

    private Long totalRecordCount;

    private List<Title> records;
}
