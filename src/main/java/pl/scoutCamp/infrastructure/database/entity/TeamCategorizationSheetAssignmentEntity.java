package pl.scoutCamp.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "isCompleted", "amount"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team_categorization_sheet_assignment")
public class TeamCategorizationSheetAssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_categorization_sheet_assignment_id")
    private Integer id;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id")
    private AssignmentEntity assignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_categorization_sheet_id")
    private TeamCategorizationSheetEntity teamCategorizationSheet;
}
