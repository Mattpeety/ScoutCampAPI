package pl.scoutCamp.infastructure.database.repository.jpa;

import lombok.AllArgsConstructor;
<<<<<<< Updated upstream
=======
import org.junit.jupiter.api.BeforeEach;
>>>>>>> Stashed changes
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
<<<<<<< Updated upstream
=======
import org.springframework.test.annotation.DirtiesContext;
>>>>>>> Stashed changes
import org.springframework.test.context.TestPropertySource;
import pl.scoutCamp.infrastructure.database.entity.RegimentEntity;
import pl.scoutCamp.infrastructure.database.repository.jpa.RegimentJpaRepository;
import pl.scoutCamp.integration.configuration.PersistenceContainerTestConfiguration;

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.scoutCamp.util.RegimentEntityFixtures.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
<<<<<<< Updated upstream
=======
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
>>>>>>> Stashed changes
public class RegimentJpaRepositoryTest {

    private RegimentJpaRepository regimentJpaRepository;

<<<<<<< Updated upstream
    @Test
    void thatRegimentCanBeSavedCorrectly() {
        // given
        var regiments = List.of(someRegiment1(), someRegiment2(), someRegiment3());
        regimentJpaRepository.saveAllAndFlush(regiments);

        // when
=======
    @BeforeEach
    public void setUp() {
        var regiments = List.of(someRegiment1(), someRegiment2(), someRegiment3());
        regimentJpaRepository.saveAllAndFlush(regiments);
    }

    @Test
    void thatRegimentCanBeSavedCorrectly() {
        // given, when
>>>>>>> Stashed changes
        List<RegimentEntity> availableRegiments = regimentJpaRepository.findAll();

        // then
        assertThat(availableRegiments).hasSize(3);
    }


    @Test
    void thatOneSpecificRegimentCanBeSavedCorrectly() {

        //given
        RegimentEntity regiment = someRegiment1();
<<<<<<< Updated upstream
        regimentJpaRepository.saveAndFlush(regiment);
=======
>>>>>>> Stashed changes

        // when
        Optional<RegimentEntity> regimentByName = regimentJpaRepository.findRegimentByName(regiment.getName());

        // then
        assertThat(regimentByName.map(RegimentEntity::getName).orElse(null)).isEqualTo(regiment.getName());
    }
}
