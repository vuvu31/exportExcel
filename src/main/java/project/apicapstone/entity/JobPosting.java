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
import java.util.HashSet;
import java.util.Set;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
@Entity
@Table(name = "table_jobPosting")
public class JobPosting  {
    @Id
    private String jobPostingId;
    @Column
    private String vacancies;
    @Column
    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
    private String datePost;
    @Column
    private String employmentInfor;
    @Column
    private String jobDescription;
    @Column
    private String jobRequirements;
    @Column
    private String status;

    // relationship  title - job posting: 1-N
    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    @JoinColumn(name = "title_id")
    private Title title;

    // relationship job posting - criteria 1-N
    @OneToMany(mappedBy="jobPosting")
    @JsonIgnore
    private Set<Criteria> criteria = new HashSet<>();

    // relationship job posting - application 1-N
    @OneToMany(mappedBy="jobPosting")
    @JsonIgnore
    private Set<Applicant> applicants = new HashSet<>();

}
