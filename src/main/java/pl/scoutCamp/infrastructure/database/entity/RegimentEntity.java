package pl.scoutCamp.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "regimentId")
@ToString(of = {"regimentId", "name"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "regiment")
public class RegimentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regiment_id")
    private Integer regimentId;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "regiment")
    private Set<TroopEntity> troops;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "regiment")
    private Set<TeamEntity> teams;
}
