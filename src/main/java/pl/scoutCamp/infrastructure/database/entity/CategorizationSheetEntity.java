package pl.scoutCamp.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "sheetType", "categorizationPeriod"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorization_sheet")
public class CategorizationSheetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categorization_sheet_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sheet_type_id")
    private SheetTypeEntity sheetType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorization_period_id")
    private CategorizationPeriodEntity categorizationPeriod;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categorizationSheet")
    private Set<AssignmentEntity> assignments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categorizationSheet")
    private Set<TeamCategorizationSheetEntity> teamCategorizationSheets;
}
