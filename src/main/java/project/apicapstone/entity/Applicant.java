package project.apicapstone.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import project.apicapstone.common.entity.BaseEntity;
import project.apicapstone.common.util.DateUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
@Entity
@Table(name = "table_application")
public class Applicant {
    @Id
    @Column
    private String applicantId;
    @Column
    private String applicantName;
    @Column
    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private LocalDate dateBirth;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String gender;
    @Column
    private String email;
    @Column
    private String certification;
    @Column
    private String status;
    @Column
    private String resumeFile;

    // relationship jobPosting - application 1-N
    @ManyToOne(fetch = FetchType.LAZY)
    // @JsonIgnore
    @JoinColumn(name = "job_posting_id")
    private JobPosting jobPosting;

    // relationship application - evaluation 1-N
    @OneToMany(mappedBy = "applicant")
    @JsonIgnore
    private Set<Evaluation> evaluations = new HashSet<>();

//    //relation empl- applicant : N-N
//    @JsonIgnore
//    @Builder.Default
//    @ManyToMany(mappedBy = "applicants", fetch = FetchType.LAZY)
//    private Set<Employee> employees = new HashSet<>();
}
