package pl.scoutCamp.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name", "regiment", "troop"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regiment_id")
    private RegimentEntity regiment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "troop_id")
    private TroopEntity troop;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private Set<TeamCategorizationSheetEntity> teamCategorizationSheets;

}
