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
@Table(name = "table_area")
public class Area {
    @Id
    @Column
    private String areaId;
    @Column
    private String name;
    @Column
    private String description;
    //relationship area - subarea: 1 - N
    @OneToMany(mappedBy = "area")
    @JsonIgnore
    private Set<Subarea> subareas = new HashSet<>();

}
