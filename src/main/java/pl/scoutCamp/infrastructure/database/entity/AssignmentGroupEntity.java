package pl.scoutCamp.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name", "ordered"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignment_group")
public class AssignmentGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_group_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "ordered")
    private Integer ordered;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "assignment_group_assignment_junction",
            joinColumns = {@JoinColumn(name = "assignment_group_id")},
            inverseJoinColumns = {@JoinColumn(name = "assignment_id")}
    )
    private Set<AssignmentEntity> assignmentsManyToMany;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignmentGroup")
    private Set<AssignmentEntity> assignments;
}
