package pl.scoutCamp.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "categorizationSheetId")
@ToString(of = {"categorizationSheetId", "sheetType", "categorizationPeriod"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorization_sheet")
public class CategorizationSheetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categorization_sheet_id")
    private Integer categorizationSheetId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sheet_type_id")
    private SheetTypeEntity sheetType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorization_period_id")
    private CategorizationPeriodEntity categorizationPeriod;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categorizationSheet")
    private Set<AssignmentEntity> assignments;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categorizationSheet")
    private Set<TeamCategorizationSheetEntity> teamCategorizationSheets;
}
