package pl.scoutCamp.infastructure.database.repository.jpa;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;
import pl.scoutCamp.infrastructure.database.repository.jpa.RegimentJpaRepository;
import pl.scoutCamp.integration.configuration.PersistenceContainerTestConfiguration;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.scoutCamp.util.RegimentEntityFixtures.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegimentJpaRepositoryTest {

    private RegimentJpaRepository regimentJpaRepository;

    @Test
    void thatRegimentCanBeSavedCorrectly() {
        // given
        var regiments = List.of(someRegiment1(), someRegiment2(), someRegiment3());
        regimentJpaRepository.saveAllAndFlush(regiments);

        // when
        List<RegimentEntity> availableRegiments = regimentJpaRepository.findAll();

        // then
        assertThat(availableRegiments).hasSize(3);
    }


    @Test
    void thatOneSpecificRegimentCanBeSavedCorrectly() {

        //given
        RegimentEntity regiment = someRegiment1();
        regimentJpaRepository.saveAndFlush(regiment);

        // when
        Optional<RegimentEntity> regimentByName = regimentJpaRepository.findRegimentByName(regiment.getName());

        // then
        assertThat(regimentByName.map(RegimentEntity::getName).orElse(null)).isEqualTo(regiment.getName());
    }
}
