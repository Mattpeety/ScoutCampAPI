package pl.scoutCamp.infastructure.database.repository.jpa;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;
import pl.scoutCamp.infrastructure.database.entity.TeamEntity;
import pl.scoutCamp.infrastructure.database.repository.jpa.RegimentJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.jpa.TeamJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.jpa.TroopJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.jpa.UserJpaRepository;
import pl.scoutCamp.integration.configuration.PersistenceContainerTestConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.scoutCamp.util.RegimentEntityFixtures.someRegiment1;
import static pl.scoutCamp.util.TeamEntityFixtures.*;
import static pl.scoutCamp.util.TroopEntityFixtures.someTroop1;
import static pl.scoutCamp.util.TroopEntityFixtures.someTroop2;
import static pl.scoutCamp.util.UserEntityFixtures.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TeamJpaRepositoryTest {

    private TeamJpaRepository teamJpaRepository;
    private RegimentJpaRepository regimentJpaRepository;
    private TroopJpaRepository troopJpaRepository;
    private UserJpaRepository userJpaRepository;

    @BeforeEach
    public void setUp() {
        var users = List.of(someUser1(), someUser2(), someUser3());
        RegimentEntity regiment = someRegiment1();
        var troops = List.of(someTroop1(), someTroop2());
        var teams = List.of(someTeam1(), someTeam2(), someTeam3());
        userJpaRepository.saveAllAndFlush(users);
        regimentJpaRepository.saveAndFlush(regiment);
        troopJpaRepository.saveAllAndFlush(troops);
        teamJpaRepository.saveAllAndFlush(teams);
    }

    @Test
    void thatTeamCanBeSavedCorrectly() {
        // given, when
        List<TeamEntity> availableTeams = teamJpaRepository.findAll();

        // then
        assertThat(availableTeams).hasSize(3);
    }


}
