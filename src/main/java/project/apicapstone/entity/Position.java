package project.apicapstone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
@Entity
@Table(name = "table_position")
public class Position {
    @Id
    private String positionId;
    @Column
    private String positionName;

    // relationship position - title: 1-N
    @OneToMany(mappedBy = "position")// cascade.ALL
    @JsonIgnore
    private Set<Title> titles = new HashSet<>();
}
