package project.apicapstone.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.common.util.DateUtils;
import project.apicapstone.validation.annonation.UniquePositionId;
import project.apicapstone.validation.annonation.UniqueTaskId;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;
@Data
public class CreateTaskDto {
    @UniqueTaskId
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
