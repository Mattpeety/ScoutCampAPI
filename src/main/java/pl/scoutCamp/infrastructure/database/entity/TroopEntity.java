package pl.scoutCamp.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "troopId")
@ToString(of = {"troopId", "regiment", "name"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "troop")
public class TroopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "troop_id")
    private Integer troopId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "regiment_id")
    private RegimentEntity regiment;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "troop")
    private Set<TeamEntity> teams;
}
