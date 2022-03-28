package project.apicapstone.common.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private String id;
}
