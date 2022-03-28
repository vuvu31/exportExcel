package project.apicapstone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import project.apicapstone.common.entity.BaseEntity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"accounts"}, callSuper = false)
@Entity
@Table(name = "table_role")
public class Role {
    @Id
    @Column
    private String roleId;
    @Column
    private String roleName;
    @Column
    private String roleDescription;
    //relation account-role : N-N
    @JsonIgnore
    @Builder.Default
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Account> accounts = new HashSet<>();
}
