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

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<CategorizationSheetEntity> categorizationSheets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_group_id")
    private AssignmentGroupEntity assignmentGroup;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "assignmentsManyToMany")
    private Set<AssignmentGroupEntity> assignmentGroups;
}
