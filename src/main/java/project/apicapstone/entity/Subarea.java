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
@Table(name = "table_subArea")
public class Subarea {
    @Id
    @Column
    private String subareaId;
    @Column
    private String name;
    @Column
    private String description;

    //relationship subarea - workplace : 1 - N
    @OneToMany(mappedBy = "subarea")
    @JsonIgnore
    private Set<Workplace> workplaces = new HashSet<>();

    //relationship area - subarea: 1 - N
    @ManyToOne(fetch = FetchType.LAZY)
    // @JsonIgnore
    @JoinColumn(name = "area_id")
    private Area area;
}
