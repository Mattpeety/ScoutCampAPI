package pl.scoutCamp.infrastructure.database.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "isDraft", "points", "createdAt", "updatedAt"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team_categorization_sheet")
public class TeamCategorizationSheetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_categorization_sheet_id")
    private Integer id;

    @Column(name = "is_draft")
    @JsonProperty(value = "isDraft")
    private boolean isDraft = true;

    @Column(name = "points")
    private Integer points;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorization_sheet_id")
    private CategorizationSheetEntity categorizationSheet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teamCategorizationSheet")
    private Set<TeamCategorizationSheetAssignmentEntity> teamCategorizationSheetAssignments;
}
