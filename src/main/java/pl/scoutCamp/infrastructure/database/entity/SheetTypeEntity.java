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
@Table(name = "sheet_type")
public class SheetTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sheet_type_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "ordered")
    private Integer ordered;

    @Column(name = "is_scored_sheet")
    private Boolean isScoredSheet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sheetType")
    private Set<CategorizationSheetEntity> categorizationSheets;
}
