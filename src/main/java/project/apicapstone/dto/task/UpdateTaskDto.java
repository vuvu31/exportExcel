package project.apicapstone.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.common.util.DateUtils;

import java.time.LocalDate;

@Data
public class UpdateTaskDto {
    private String taskId;

    private String taskName;

    private String owner;

    private String status;

    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate startDate;

    private String workPlan;

    private String duration;

    private String priority;
}
