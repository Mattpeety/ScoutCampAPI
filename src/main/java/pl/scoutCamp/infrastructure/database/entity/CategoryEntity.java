package pl.scoutCamp.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name", "imagePath"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_path")
    private String imagePath;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<AssignmentEntity> assignments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<AssignmentCategoryMinimumEntity> assignmentCategoryMinimums;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<TeamCategorizationSheetEntity> teamCategorizationSheets;
}
