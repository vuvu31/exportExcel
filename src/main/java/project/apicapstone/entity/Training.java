package project.apicapstone.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.common.util.DateUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "table_training")
public class Training {
    @Id
    @Column
    private String trainingId;
    @Column
    private String trainingName;
    @Column
    private String trainingDescription;
    @Column
    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private String startDate;
    @Column
    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private String endDate;
    @Column
    private String status;
    @Column
    private String trainer;

    //relation employee - training : N-N
    @JsonIgnore
    @Builder.Default
    @ManyToMany(mappedBy = "trainings",fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();

}
