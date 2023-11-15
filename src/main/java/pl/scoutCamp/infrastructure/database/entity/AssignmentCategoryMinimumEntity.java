package pl.scoutCamp.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "assignmentCategoryMinimumId")
@ToString(of = {"assignmentCategoryMinimumId"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignment_category_minimum")
public class AssignmentCategoryMinimumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_category_minimum_id")
    private Integer assignmentCategoryMinimumId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assignment_id")
    private AssignmentEntity assignment;

}