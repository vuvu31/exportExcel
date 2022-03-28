package project.apicapstone.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.common.util.DateUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
@Entity
@Table(name = "table_contract")
public class Contract {
    @Id
    @Column
    private String contractId;
    @Column
    private String contractName;
    @Column
    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate startDate;
    @Column
    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate endDate;
    @Column
    private String status;
    @Column
    private double salary;
    @Column
    private String type;
    @Column
    private Long duration;
    @Column
    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate signDate;
    @Column
    private String wage;
    @Column
    private String note;
    @Column
    private String attachedFile;

    // relationship emply - contract 1-N
    @ManyToOne(fetch = FetchType.LAZY)
   // @JsonIgnore
    @JoinColumn(name = "employee_id")
    private Employee employee;
    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    //@JsonIgnore
    private Employee employee;*/

    // relationship contract - dependant 1-N
    @OneToMany(mappedBy = "contract")
    @JsonIgnore
    private Set<Allowance> allowances = new HashSet<>();


}
