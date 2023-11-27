package pl.scoutCamp.infastructure.database.repository.jpa;

import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import pl.scoutCamp.infrastructure.database.entity.UserEntity;
import pl.scoutCamp.infrastructure.database.repository.jpa.UserJpaRepository;
import pl.scoutCamp.integration.configuration.PersistenceContainerTestConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static pl.scoutCamp.util.UserEntityFixtures.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PersistenceContainerTestConfiguration.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserJpaRepositoryTest {

   private  UserJpaRepository userJpaRepository;
// TODO ogarnąć tabelę user: prawdopodobnie należy dodać kolumnę team_id. Zobaczyć na zajavce.
    @Test
    void thatUserCanBeSavedCorrectly() {
        // given
        List<UserEntity> users = List.of(someUser1(), someUser2(), someUser3());
        userJpaRepository.saveAllAndFlush(users);

        // when
        List<UserEntity> availableUsers = userJpaRepository.findAll();

        // then
        assertThat(availableUsers).hasSize(3);
    }
}
