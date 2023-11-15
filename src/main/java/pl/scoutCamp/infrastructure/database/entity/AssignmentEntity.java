package pl.scoutCamp.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "assignmentId")
@ToString(of = {"assignmentId", "assignmentType", "description", "maxPoints", "maxScoringValue"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignment")
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private Integer assignmentId;

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

    @ManyToMany(mappedBy = "assignments")
    @JoinColumn(name = "assignment_group_id")
    private Set<AssignmentGroupEntity> assignmentGroups;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "assignment")
    private Set<TeamCategorizationSheetAssignmentEntity> teamCategorizationSheetAssignments;
}
