package pl.scoutCamp.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.scoutCamp.business.dao.TeamCategorizationSheetDAO;
import pl.scoutCamp.domain.TeamCategorizationSheet;
import pl.scoutCamp.infrastructure.database.repository.jpa.TeamCategorizationSheetJpaRepository;
import pl.scoutCamp.infrastructure.database.repository.mapper.TeamCategorizationSheetEntityMapper;

import java.util.Optional;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class TeamCategorizationSheetRepository implements TeamCategorizationSheetDAO {

    TeamCategorizationSheetJpaRepository teamCategorizationSheetJpaRepository;
    TeamCategorizationSheetEntityMapper teamCategorizationSheetEntityMapper;
    @Override
    public Optional<TeamCategorizationSheet> findTeamCategorizationSheetById(Integer id) {
return teamCategorizationSheetJpaRepository.findTeamCategorizationSheetById(id)
        .map(teamCategorizationSheetEntityMapper::mapFromEntity);
    }
}
