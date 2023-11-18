package pl.scoutCamp.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "assignmentType", "description", "maxPoints", "maxScoringValue"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignment")
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private Integer id;

    @Column(name = "assignment_type")
    private String assignmentType;

    @Column(name = "description")
    private String description;

    @Column(name = "max_points")
    private Integer maxPoints;

    @Column(name = "max_scoring_value")
    private Integer maxScoringValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorization_sheet_id")
    private CategorizationSheetEntity categorizationSheet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "assignments")
    private Set<AssignmentGroupEntity> assignmentGroups;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assignment_group_id")
    private AssignmentGroupEntity assignmentGroup;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "assignment")
    private Set<TeamCategorizationSheetAssignmentEntity> teamCategorizationSheetAssignments;
}
