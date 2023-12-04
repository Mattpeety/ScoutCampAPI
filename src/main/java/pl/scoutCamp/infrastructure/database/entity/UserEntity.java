package pl.scoutCamp.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "firstName", "lastName"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "scoutcamp_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
private List<TeamEntity> teams;

}
