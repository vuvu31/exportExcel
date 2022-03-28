package project.apicapstone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
@Entity
@Table(name = "table_workplace")
public class Workplace {
    @Id
    @Column
    private String workplaceId;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String type;

    //relationship workplace - employee: 1 - N
    @OneToMany(mappedBy = "workplace")
    @JsonIgnore
    private Set<Employee> employees = new HashSet<>();

    // relationship subarea - workplace: 1-N
    @ManyToOne(fetch = FetchType.LAZY)
    // @JsonIgnore
    @JoinColumn(name = "subarea_id")
    private Subarea subarea;


}
