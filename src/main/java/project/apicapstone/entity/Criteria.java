package project.apicapstone.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.apicapstone.common.entity.BaseEntity;

import javax.persistence.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
@Entity
@Table(name = "table_criteria")
public class Criteria {
    @Id
    private String criteriaId;
    @Column
    private String criteriaDescription;
    @Column
    private String weight;

    // relationship job posting - criteria 1-N
    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonIgnore
    @JoinColumn(name = "job_posting_id")
    private JobPosting jobPosting;
}
