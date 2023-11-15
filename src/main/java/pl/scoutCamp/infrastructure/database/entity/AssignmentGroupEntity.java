package pl.scoutCamp.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "assignmentGroupId")
@ToString(of = {"assignmentGroupId", "name", "ordered"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignment_group")
public class AssignmentGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_group_id")
    private Integer assignmentGroupId;

    @Column(name = "name")
    private String name;

    @Column(name = "ordered")
    private Integer ordered;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "assignment_group_assignment_junction",
            joinColumns = {@JoinColumn(name = "assignment_group_id")},
            inverseJoinColumns = {@JoinColumn(name = "assignment_id")}
    )
    private Set<AssignmentEntity> assignments;
}
