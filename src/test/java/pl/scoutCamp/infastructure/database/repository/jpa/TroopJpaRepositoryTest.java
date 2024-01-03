
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
import pl.scoutCamp.infrastructure.database.entity.TroopEntity;
import pl.scoutCamp.infrastructure.database.repository.jpa.RegimentJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.jpa.TroopJpaRepository;
import pl.scoutCamp.integration.configuration.PersistenceContainerTestConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.scoutCamp.util.RegimentEntityFixtures.*;
import static pl.scoutCamp.util.TroopEntityFixtures.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TroopJpaRepositoryTest {
    private TroopJpaRepository troopJpaRepository;
    private RegimentJpaRepository regimentJpaRepository;

    @BeforeEach
    public void setUp() {
        List<RegimentEntity> regiments = List.of(someRegiment1(), someRegiment2(), someRegiment3());
        List<TroopEntity> troops = List.of(someTroop1(), someTroop2(), someTroop3(), someTroop4(), someTroop5(), someTroop6());
        regimentJpaRepository.saveAllAndFlush(regiments);
        troopJpaRepository.saveAllAndFlush(troops);
    }

    @Test
    void thatTroopCanBeSavedCorrectly() {
        // given
        // when
        List<TroopEntity> availableTroops = troopJpaRepository.findAll();

        // then
        assertThat(availableTroops).hasSize(6);
    }

    @Test
    void thatTroopsInRegimentCanBeSavedCorrectly() {
        // given
        RegimentEntity regiment = someRegiment2();

        // when
        List<TroopEntity> availableTroopsInRegiment = troopJpaRepository
                .findAll()
                .stream()
                .filter(troop -> troop.getRegiment().getName().equals(regiment.getName()))
                .toList();


        // then
        assertThat(availableTroopsInRegiment).hasSize(3);
    }
}
