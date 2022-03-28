package project.apicapstone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.apicapstone.common.entity.BaseEntity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "table_skill")
public class Skill  {
    @Id
    private String skillId;
    @Column
    private String skillName;
    @Column
    private String description;

    //relation empl- skill : N-N
    @JsonIgnore
    @Builder.Default
    @ManyToMany(mappedBy = "skills",fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();
}
