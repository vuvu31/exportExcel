package project.apicapstone.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.common.util.DateUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "table_task")
public class Task {
    @Id
    @Column
    private String taskId;
    @Column
    private String taskName;
    @Column
    private String owner;
    @Column
    private String status;
    @Column
    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate startDate;
    @Column
    private String workPlan;
    @Column
    private String duration;
    @Column
    private String priority;

    //relation employee - task : N-N
    @JsonIgnore
    @Builder.Default
    @ManyToMany(mappedBy = "tasks",fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();

}
