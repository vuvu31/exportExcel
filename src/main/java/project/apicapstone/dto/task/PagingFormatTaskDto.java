package project.apicapstone.dto.task;

import lombok.Data;
import project.apicapstone.entity.Task;
import project.apicapstone.entity.Title;

import java.util.List;
@Data
public class PagingFormatTaskDto {
    private int pageNumber;

    private int pageSize;

    private Long totalRecordCount;

    private List<Task> records;
}
